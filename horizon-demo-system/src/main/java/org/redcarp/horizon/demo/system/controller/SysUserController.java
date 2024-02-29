package org.redcarp.horizon.demo.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redcarp.common.base.domain.Request;
import org.redcarp.common.base.domain.Response;
import org.redcarp.horizon.demo.system.dto.RegisterUserInput;
import org.redcarp.horizon.demo.system.entity.SysUser;
import org.redcarp.horizon.demo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "用户管理")
@RestController
@RequestMapping("/sysUser")
@Slf4j
public class SysUserController {
	@Autowired
	private ISysUserService sysUserService;


	@ApiOperation("通过id查询数据")
	@PostMapping("/getById")
	public Response<SysUser> getById(@RequestBody Request<String> request) {
		return Response.ok(sysUserService.getById(request.getData()));
	}

	@ApiOperation("新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody RegisterUserInput input) {
		return Response.ok(sysUserService.register(input));
	}

	@ApiOperation("编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysUser> request) {
		SysUser sysUser = request.getData();
		return Response.ok(sysUserService.saveOrUpdate(sysUser));
	}


	@ApiOperation("通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysUserService.removeById(request.getData()));
	}

	@ApiOperation("获取列表")
	@PostMapping("/getList")
	public Response<List<SysUser>> getList(@RequestBody Request<SysUser> request) {
		return Response.ok(sysUserService.getList(request));
	}


}