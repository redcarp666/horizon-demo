package org.redcarp.horizon.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redcarp.horizon.core.util.AssertionUtils;
import org.redcarp.horizon.demo.system.dto.PermissionUserRequest;
import org.redcarp.horizon.demo.system.dto.UserRoleDto;
import org.redcarp.horizon.demo.system.entity.SysRole;
import org.redcarp.horizon.demo.system.entity.SysUser;
import org.redcarp.horizon.demo.system.entity.SysUserRole;
import org.redcarp.horizon.demo.system.mapper.SysUserRoleMapper;
import org.redcarp.horizon.demo.system.service.ISysRoleService;
import org.redcarp.horizon.demo.system.service.ISysUserRoleService;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

	@Autowired
	ISysRoleService roleService;

	@Override
	public Boolean permissionUser(PermissionUserRequest request) {

		remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getRoleId,
		                                                  request.getRoleId()).in(SysUserRole::getUserId,
		                                                                          request.getPermissionList()));
		List<SysUserRole> sysUserRoleList = request.getPermissionList().stream().map(userId -> {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(request.getRoleId());
			sysUserRole.setUserId(userId);
			return sysUserRole;

		}).collect(Collectors.toList());
		return saveBatch(sysUserRoleList);
	}

	@Override
	public UserRoleDto getRoles(String userId) {
		AssertionUtils.shouldNotNull(userId);
		UserRoleDto userRoleDto = new UserRoleDto();
		userRoleDto.setUserId(userId);
		List<String> roleIds = getBaseMapper().selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId,
		                                                                                           userId)).stream().map(
				SysUserRole::getRoleId).collect(Collectors.toList());
		if (!roleIds.isEmpty()) {
			userRoleDto.setRoleNames(roleService.listByIds(roleIds).stream().map(SysRole::getRoleName).collect(
					Collectors.toList()));
		}
		return userRoleDto;
	}

	@EventListener
	public void addDefaultRoleWhenUserRegister(SysUser user) {
		String roleId = "1";
		SysRole sysRole = roleService.getOne(new LambdaQueryWrapper<SysRole>().eq(HorizonBaseEntity::getId, roleId));
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(user.getId());
		sysUserRole.setRoleId(sysRole.getId());
		save(sysUserRole);
	}
}
