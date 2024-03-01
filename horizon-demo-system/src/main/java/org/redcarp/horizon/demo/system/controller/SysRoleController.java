package org.redcarp.horizon.demo.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redcarp.horizon.common.base.domain.Request;
import org.redcarp.horizon.common.base.domain.Response;
import org.redcarp.horizon.demo.system.dto.GetPermissionRequest;
import org.redcarp.horizon.demo.system.dto.PermissionMenuRequest;
import org.redcarp.horizon.demo.system.dto.PermissionUserRequest;
import org.redcarp.horizon.demo.system.entity.SysRole;
import org.redcarp.horizon.demo.system.service.ISysRoleService;
import org.redcarp.horizon.demo.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;


	@ApiOperation("通过id查询数据")
	@PostMapping("/getById")
	public Response<SysRole> getById(@RequestBody Request<String> request) {
		return Response.ok(sysRoleService.getById(request.getData()));
	}

	@ApiOperation("新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysRole> request) {
		SysRole sysRole = request.getData();
		return sysRoleService.save(sysRole) == true ? Response.ok(sysRole.getId()) : Response.fail();
	}

	@ApiOperation("编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysRole> request) {
		SysRole sysRole = request.getData();
		return Response.ok(sysRoleService.saveOrUpdate(sysRole));
	}

	@ApiOperation("通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysRoleService.removeById(request.getData()));
	}

	@ApiOperation("通过主键删除数据")
	@PostMapping("/getList")
	public Response<Page<SysRole>> getList(@RequestBody Request<SysRole> request) {
		return Response.ok(sysRoleService.getList(request));
	}

	@ApiOperation("角色授权菜单")
	@PostMapping("/permissionMenu")
	public Response<Boolean> permissionMenu(@RequestBody Request<PermissionMenuRequest> request) {
		return Response.ok(sysRoleService.permissionMenu(request.getData()));
	}

	@ApiOperation("角色分配用户")
	@PostMapping("/permissionUser")
	public Response<Boolean> permissionUser(@RequestBody Request<PermissionUserRequest> request) {
		return Response.ok(sysUserRoleService.permissionUser(request.getData()));
	}

	@ApiOperation("获取角色权限")
	@PostMapping("/getPermission")
	public Response<List<String>> getPermission(@RequestBody Request<GetPermissionRequest> request) {
		return Response.ok(sysRoleService.getPermission(request.getData()));
	}


}