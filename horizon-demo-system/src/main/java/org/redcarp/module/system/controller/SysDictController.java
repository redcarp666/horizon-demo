package org.redcarp.module.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.redcarp.common.base.domain.Request;
import org.redcarp.common.base.domain.Response;
import org.redcarp.module.system.entity.SysDict;
import org.redcarp.module.system.entity.SysDictData;
import org.redcarp.module.system.service.ISysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "字典管理")
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    @ApiOperation("通过id查询数据")
    @PostMapping("/getById")
    public Response<SysDict> getById(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getById(request.getData()));
    }


    @ApiOperation("新增")
    @PostMapping("/add")
    public Response<String> add(@RequestBody Request<SysDict> request){
        SysDict sysPost = request.getData();
        return sysDictService.save(sysPost)==true?Response.ok(sysPost.getId()):Response.fail();
    }


    @ApiOperation("编辑")
    @PostMapping("/edit")
    public Response<Boolean> edit(@RequestBody Request<SysDict> request){
        SysDict sysDict = request.getData();
        return Response.ok(sysDictService.saveOrUpdate(sysDict));
    }



    @ApiOperation("通过主键删除数据")
    @PostMapping("/deleteById")
    public Response<Boolean> deleteById(@RequestBody Request<String> request){
        return Response.ok(sysDictService.removeById(request.getData()));
    }


    @ApiOperation("获取字典类型列表")
    @PostMapping("/getDictList")
    public Response<Page<SysDict>> getDictList(@RequestBody Request<SysDict> request){
        return Response.ok(sysDictService.getDictList(request));
    }

    @ApiOperation("获取字段数据列表")
    @PostMapping("/getDictDataList")
    public Response<Page<SysDictData>> getDictDataList(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.getDictDataList(request));
    }

    @ApiOperation("添加字典数据")
    @PostMapping("/addDictData")
    public Response<Boolean> addDictData(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.addDictData(request.getData()));
    }

    @ApiOperation("更新字典数据")
    @PostMapping("/updateDictData")
    public Response<Boolean> updateDictData(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.updateDictData(request.getData()));
    }


    @ApiOperation("通过字典类型获取字典")
    @PostMapping("/getDictByDictType")
    public Response<SysDict> getDictByDictType(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getDictByDictType(request.getData()));
    }

    @ApiOperation("通过字典类型获取字典数据")
    @PostMapping("/getDictDataByDictType")
    public Response<List<SysDictData>> getDictDataByDictType(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getDictDataByDictType(request.getData()));
    }

}