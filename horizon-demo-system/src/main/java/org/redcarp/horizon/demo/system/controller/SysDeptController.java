package org.redcarp.horizon.demo.system.controller;


import org.redcarp.horizon.demo.system.entity.SysDept;
import org.redcarp.horizon.demo.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redcarp.common.base.domain.Request;
import org.redcarp.common.base.domain.Response;
import org.redcarp.horizon.core.datastructure.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "部门管理")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {
	@Autowired
	private ISysDeptService sysDeptService;

	@ApiOperation("通过id查询数据")
	@PostMapping("/getById")
	public Response<SysDept> getById(@RequestBody Request<String> request) {
		return Response.ok(sysDeptService.getById(request.getData()));
	}

	@ApiOperation("新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysDept> request) {
		SysDept sysDept = request.getData();
		return sysDeptService.save(sysDept) == true ? Response.ok(sysDept.getId()) : Response.fail();
	}

	@ApiOperation("编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysDept> request) {
		SysDept sysDept = request.getData();
		return Response.ok(sysDeptService.saveOrUpdate(sysDept));
	}


	@ApiOperation("通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysDeptService.removeById(request.getData()));
	}


	@ApiOperation("获取部门树")
	@PostMapping("/getDeptTree")
	public Response<Tree<SysDept>> getDeptTree() {
		return Response.ok(sysDeptService.getDeptTree());
	}


	@ApiOperation("重置部门树")
	@PostMapping("/refreshDeptTree")
	public Response<Boolean> refreshDeptTree() {
		return Response.ok(sysDeptService.refreshDeptTree());
	}


}