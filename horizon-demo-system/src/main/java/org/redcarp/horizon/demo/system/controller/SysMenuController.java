package org.redcarp.horizon.demo.system.controller;


import org.redcarp.horizon.demo.system.entity.SysMenu;
import org.redcarp.horizon.demo.system.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.redcarp.horizon.common.base.domain.Request;
import org.redcarp.horizon.common.base.domain.Response;
import org.redcarp.horizon.core.datastructure.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "菜单管理")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;

	@ApiOperation("通过id查询数据")
	@PostMapping("/getById")
	public Response<SysMenu> getById(@RequestBody Request<String> request) {
		return Response.ok(sysMenuService.getById(request.getData()));
	}

	@ApiOperation("新增")
	@PostMapping("/add")
	public Response<String> add(@RequestBody Request<SysMenu> request) {
		SysMenu sysMenu = request.getData();
		return sysMenuService.save(sysMenu) ? Response.ok(sysMenu.getId()) : Response.fail();
	}

	@ApiOperation("编辑")
	@PostMapping("/edit")
	public Response<Boolean> edit(@RequestBody Request<SysMenu> request) {
		SysMenu sysMenu = request.getData();
		return Response.ok(sysMenuService.saveOrUpdate(sysMenu));
	}


	@ApiOperation("通过主键删除数据")
	@PostMapping("/deleteById")
	public Response<Boolean> deleteById(@RequestBody Request<String> request) {
		return Response.ok(sysMenuService.removeById(request.getData()));
	}


	@ApiOperation("获取菜单树")
	@PostMapping("/getMenuTree")
	public Response<Tree<SysMenu>> getMenuTree() {
		return Response.ok(sysMenuService.getMenuTree());
	}

	@ApiOperation("重置菜单树")
	@PostMapping("/refreshMenuTree")
	public Response<Boolean> refreshMenuTree() {
		return Response.ok(sysMenuService.refreshMenuTree());
	}


	@ApiOperation("获取用户菜单树")
	@PostMapping("/getUserMenuTree")
	public Response<Tree<SysMenu>> getUserMenuTree() {
		return Response.ok(sysMenuService.getUserMenuTree());
	}


}