package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.common.base.domain.Request;
import org.redcarp.horizon.demo.system.entity.SysRole;
import org.redcarp.horizon.demo.system.dto.GetPermissionRequest;
import org.redcarp.horizon.demo.system.dto.PermissionMenuRequest;

import java.util.List;

public interface ISysRoleService extends IService<SysRole> {
	Page<SysRole> getList(Request<SysRole> request);

	Boolean permissionMenu(PermissionMenuRequest request);

	List<String> getPermission(GetPermissionRequest request);

}
