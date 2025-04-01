package org.redcarp.horizon.demo.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redcarp.horizon.demo.system.entity.SysPost;
import org.redcarp.horizon.demo.system.service.ISysPostService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "岗位管理")
@RestController
@RequestMapping("/sysPost")
public class SysPostController {

	@Autowired
	private ISysPostService sysPostService;

	@Operation(summary = "通过id查询数据")
	@PostMapping("/getById")
	public Response<SysPost> getById(@RequestBody Request<String> request) {
		return Response.ok(sysPostService.getById(request.getData()));
	}

	@Operation(summary = "新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysPost> request) {
		SysPost sysPost = request.getData();
		return sysPostService.save(sysPost) == true ? Response.ok(sysPost.getId()) : Response.fail();
	}

	@Operation(summary = "编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysPost> request) {
		SysPost sysPost = request.getData();
		return Response.ok(sysPostService.saveOrUpdate(sysPost));
	}


	@Operation(summary = "通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysPostService.removeById(request.getData()));
	}

	@Operation(summary = "获取列表")
	@PostMapping("/getList")
	public Response<Page<SysPost>> getList(@RequestBody Request<SysPost> request) {
		return Response.ok(sysPostService.getList(request));
	}


}