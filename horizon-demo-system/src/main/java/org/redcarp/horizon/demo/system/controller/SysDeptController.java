package org.redcarp.horizon.demo.system.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redcarp.horizon.core.datastructure.Tree;
import org.redcarp.horizon.demo.system.entity.SysDept;
import org.redcarp.horizon.demo.system.service.ISysDeptService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "部门管理")
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {
	@Autowired
	private ISysDeptService sysDeptService;

	@Operation(summary = "通过id查询数据")
	@PostMapping("/getById")
	public Response<SysDept> getById(@RequestBody Request<String> request) {
		return Response.ok(sysDeptService.getById(request.getData()));
	}

	@Operation(summary = "新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysDept> request) {
		SysDept sysDept = request.getData();
		return sysDeptService.save(sysDept) == true ? Response.ok(sysDept.getId()) : Response.fail();
	}

	@Operation(summary = "编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysDept> request) {
		SysDept sysDept = request.getData();
		return Response.ok(sysDeptService.saveOrUpdate(sysDept));
	}


	@Operation(summary = "通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysDeptService.removeById(request.getData()));
	}


	@Operation(summary = "获取部门树")
	@PostMapping("/getDeptTree")
	public Response<Tree<SysDept>> getDeptTree() {
		return Response.ok(sysDeptService.getDeptTree());
	}


	@Operation(summary = "重置部门树")
	@PostMapping("/refreshDeptTree")
	public Response<Boolean> refreshDeptTree() {
		return Response.ok(sysDeptService.refreshDeptTree());
	}


}