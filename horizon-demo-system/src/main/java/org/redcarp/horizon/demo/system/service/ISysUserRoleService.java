package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.demo.system.dto.UserRoleDto;
import org.redcarp.horizon.demo.system.entity.SysUserRole;
import org.redcarp.horizon.demo.system.dto.PermissionUserRequest;

public interface ISysUserRoleService extends IService<SysUserRole> {
	Boolean permissionUser(PermissionUserRequest request);

	/**
	 * 通过UserId获取所有角色
	 *
	 * @param userId 用户ID
	 * @return UserRoles
	 * @author redcarp
	 * @date 2024/2/21
	 */
	UserRoleDto getRoles(String userId);
}
