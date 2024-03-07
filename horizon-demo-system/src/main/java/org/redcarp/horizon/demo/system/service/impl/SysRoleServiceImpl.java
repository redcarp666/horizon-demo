package org.redcarp.horizon.demo.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.component.redis.RedisService;
import org.redcarp.horizon.demo.system.dto.GetPermissionRequest;
import org.redcarp.horizon.demo.system.dto.PermissionMenuRequest;
import org.redcarp.horizon.demo.system.entity.SysRole;
import org.redcarp.horizon.demo.system.entity.SysRoleMenu;
import org.redcarp.horizon.demo.system.mapper.SysRoleMapper;
import org.redcarp.horizon.demo.system.service.ISysRoleMenuService;
import org.redcarp.horizon.demo.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

	@Autowired
	ISysRoleMenuService sysRoleMenuService;

	@Autowired
	RedisService redisService;

	@Override
	public Page<SysRole> getList(Request<SysRole> request) {
		SysRole sysRole = request.getData();
		LambdaQueryWrapper<SysRole> wrapper = Wrappers.lambdaQuery(SysRole.class);
		wrapper.eq(ObjectUtil.isNotNull(sysRole.getRoleName()), SysRole::getRoleName, sysRole.getRoleName());
		wrapper.eq(ObjectUtil.isNotNull(sysRole.getStatus()), SysRole::getStatus, sysRole.getStatus());
		return this.page(request.getPage(), wrapper);
	}

	@Override
	public Boolean permissionMenu(PermissionMenuRequest request) {
		//角色授权先清空之前的权限
		sysRoleMenuService.remove(Wrappers.lambdaQuery(SysRoleMenu.class).eq(SysRoleMenu::getRoleId,
		                                                                     request.getRoleId()));
		List<SysRoleMenu> sysRoleMenuList = request.getPermissionList().stream().map(o -> {
			SysRoleMenu sysRoleMenu = new SysRoleMenu();
			BeanUtil.copyProperties(o, sysRoleMenu);
			sysRoleMenu.setRoleId(request.getRoleId());
			return sysRoleMenu;

		}).collect(Collectors.toList());
		return sysRoleMenuService.saveBatch(sysRoleMenuList);
	}


	@Override
	public List<String> getPermission(GetPermissionRequest request) {
		List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(Wrappers.lambdaQuery(SysRoleMenu.class).eq(
				SysRoleMenu::getRoleId,
				request.getRoleId()));
		return sysRoleMenuList.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
	}


}
