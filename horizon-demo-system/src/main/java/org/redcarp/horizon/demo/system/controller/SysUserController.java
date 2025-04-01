package org.redcarp.horizon.demo.system.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.redcarp.horizon.demo.system.dto.RegisterUserInput;
import org.redcarp.horizon.demo.system.entity.SysUser;
import org.redcarp.horizon.demo.system.service.ISysUserService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "用户管理")
@RestController
@RequestMapping("/sysUser")
@Log4j2
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;


	@Operation(summary = "通过id查询数据")
	@PostMapping("/getById")
	public Response<SysUser> getById(@RequestBody Request<String> request) {
		return Response.ok(sysUserService.getById(request.getData()));
	}

	@Operation(summary = "新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody RegisterUserInput input) {
		return Response.ok(sysUserService.register(input));
	}

	@Operation(summary = "编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysUser> request) {
		SysUser sysUser = request.getData();
		return Response.ok(sysUserService.saveOrUpdate(sysUser));
	}


	@Operation(summary = "通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysUserService.removeById(request.getData()));
	}

	@Operation(summary = "获取列表")
	@PostMapping("/getList")
	@PreAuthorize("isAuthenticated()")
	public Response<Page<SysUser>> getList(@RequestBody Request<SysUser> request) {
		return Response.ok(sysUserService.getList(request));
	}


}