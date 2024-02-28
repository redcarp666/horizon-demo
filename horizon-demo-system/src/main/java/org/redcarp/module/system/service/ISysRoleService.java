package org.redcarp.module.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.common.base.domain.Request;
import org.redcarp.module.system.entity.SysRole;
import org.redcarp.module.system.dto.GetPermissionRequest;
import org.redcarp.module.system.dto.PermissionMenuRequest;

import java.util.List;

public interface ISysRoleService extends IService<SysRole> {
	Page<SysRole> getList(Request<SysRole> request);

	Boolean permissionMenu(PermissionMenuRequest request);

	List<String> getPermission(GetPermissionRequest request);

}
