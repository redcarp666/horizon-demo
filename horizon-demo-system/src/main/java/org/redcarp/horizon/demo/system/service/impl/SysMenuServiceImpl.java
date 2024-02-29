package org.redcarp.horizon.demo.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.redcarp.common.base.constant.RedisConstants;
import org.redcarp.horizon.component.redis.RedisService;
import org.redcarp.horizon.core.datastructure.Tree;
import org.redcarp.horizon.demo.system.entity.SysMenu;
import org.redcarp.horizon.demo.system.entity.SysRoleMenu;
import org.redcarp.horizon.demo.system.entity.SysUserRole;
import org.redcarp.horizon.demo.system.mapper.SysMenuMapper;
import org.redcarp.horizon.demo.system.service.ISysMenuService;
import org.redcarp.horizon.demo.system.service.ISysRoleMenuService;
import org.redcarp.horizon.demo.system.service.ISysRoleService;
import org.redcarp.horizon.demo.system.service.ISysUserRoleService;
import org.redcarp.horizon.security.jwt.handler.CurrentUserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

	@Autowired
	RedisService redisService;
	@Autowired
	ISysRoleService sysRoleService;
	@Autowired
	ISysUserRoleService sysUserRoleService;
	@Autowired
	ISysRoleMenuService sysRoleMenuService;

	@Override
	public Tree<SysMenu> getMenuTree() {
		Tree<SysMenu> tree = redisService.get(RedisConstants.MENU_TREE_GLOBAL_PREFIX, Tree.class);
		if (null != tree) {
			return tree;
		}
		List<SysMenu> sysMenuList = this.list();
		String rootId = sysMenuList.stream().filter(o -> StrUtil.isEmpty(o.getParentId())).findFirst().get().getId();
		tree = getMenuTree(sysMenuList, rootId);
		//        redisService.set(Constants.Redis.MENU_TREE_GLOBAL_PREFIX,tree,0);
		return tree;
	}

	@Override
	public Boolean refreshMenuTree() {
		redisService.del(RedisConstants.MENU_TREE_PREFIX + "*");
		return true;
	}

	@Override
	public Tree<SysMenu> getUserMenuTree() {

		Tree<SysMenu> menuTree = null;
		if ("admin".equals(CurrentUserHolder.getCurrentUserName())) {
			menuTree = getMenuTree();
		} else {
			List<SysUserRole> sysUserRoleList = sysUserRoleService.list(Wrappers.lambdaQuery(SysUserRole.class).eq(
					SysUserRole::getUserId,
					CurrentUserHolder.getCurrentUserId()));
			if (ObjectUtil.isNotEmpty(sysUserRoleList)) {
				List<String> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
				//并集用户所有角色的权限
				List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(Wrappers.lambdaQuery(SysRoleMenu.class).in(
						SysRoleMenu::getRoleId,
						roleIdList));
				List<String> menuIdList = sysRoleMenuList.stream().map(o -> o.getMenuId()).collect(Collectors.toList());
				if (ObjectUtil.isNotEmpty(menuIdList)) {
					List<SysMenu> sysMenuList = this.list(Wrappers.lambdaQuery(SysMenu.class).in(SysMenu::getId,
					                                                                             menuIdList));
					String rootId = sysMenuList.stream().filter(o -> StrUtil.isEmpty(o.getParentId())).findFirst().get().getId();
					menuTree = getMenuTree(sysMenuList, rootId);
				}
			}
		}

		return menuTree;
	}


	public Tree<SysMenu> getMenuTree(List<SysMenu> sysMenuList, String id) {
		Tree<SysMenu> tree = new Tree<>();
		SysMenu menu = sysMenuList.stream().filter(o -> StrUtil.equals(id, o.getId())).findFirst().get();
		tree.setId(menu.getId());
		tree.setName(menu.getMenuName());
		tree.setParentId(menu.getParentId());
		tree.setData(menu);
		List<Tree<SysMenu>> treeChildren = Lists.newArrayList();
		List<SysMenu> subMenuList = sysMenuList.stream().filter(o -> StrUtil.equals(id, o.getParentId())).collect(
				Collectors.toList());
		for (SysMenu subMenu : subMenuList) {
			Tree<SysMenu> menuTree = getMenuTree(sysMenuList, subMenu.getId());
			treeChildren.add(menuTree);
		}
		tree.setChildren(treeChildren.isEmpty() ? null : treeChildren);
		return tree;
	}


}
