package org.redcarp.horizon.demo.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redcarp.horizon.demo.system.dto.GetPermissionRequest;
import org.redcarp.horizon.demo.system.dto.PermissionMenuRequest;
import org.redcarp.horizon.demo.system.dto.PermissionUserRequest;
import org.redcarp.horizon.demo.system.entity.SysRole;
import org.redcarp.horizon.demo.system.service.ISysRoleService;
import org.redcarp.horizon.demo.system.service.ISysUserRoleService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "角色管理")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;


	@Operation(summary = "通过id查询数据")
	@PostMapping("/getById")
	public Response<SysRole> getById(@RequestBody Request<String> request) {
		return Response.ok(sysRoleService.getById(request.getData()));
	}

	@Operation(summary = "新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysRole> request) {
		SysRole sysRole = request.getData();
		return sysRoleService.save(sysRole) ? Response.ok(sysRole.getId()) : Response.fail();
	}

	@Operation(summary = "编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysRole> request) {
		SysRole sysRole = request.getData();
		return Response.ok(sysRoleService.saveOrUpdate(sysRole));
	}

	@Operation(summary = "通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysRoleService.removeById(request.getData()));
	}

	@Operation(summary = "通过主键删除数据")
	@PostMapping("/getList")
	public Response<Page<SysRole>> getList(@RequestBody Request<SysRole> request) {
		return Response.ok(sysRoleService.getList(request));
	}

	@Operation(summary = "角色授权菜单")
	@PostMapping("/permissionMenu")
	public Response<Boolean> permissionMenu(@RequestBody Request<PermissionMenuRequest> request) {
		return Response.ok(sysRoleService.permissionMenu(request.getData()));
	}

	@Operation(summary = "角色分配用户")
	@PostMapping("/permissionUser")
	public Response<Boolean> permissionUser(@RequestBody Request<PermissionUserRequest> request) {
		return Response.ok(sysUserRoleService.permissionUser(request.getData()));
	}

	@Operation(summary = "获取角色权限")
	@PostMapping("/getPermission")
	public Response<List<String>> getPermission(@RequestBody Request<GetPermissionRequest> request) {
		return Response.ok(sysRoleService.getPermission(request.getData()));
	}


}