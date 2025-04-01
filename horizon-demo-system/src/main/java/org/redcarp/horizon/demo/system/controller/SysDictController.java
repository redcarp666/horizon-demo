package org.redcarp.horizon.demo.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.redcarp.horizon.demo.system.entity.SysDict;
import org.redcarp.horizon.demo.system.entity.SysDictData;
import org.redcarp.horizon.demo.system.service.ISysDictService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "字典管理")
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    @Operation(summary = "通过id查询数据")
    @PostMapping("/getById")
    public Response<SysDict> getById(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getById(request.getData()));
    }


    @Operation(summary = "新增")
    @PostMapping("/add")
    public Response<String> add(@RequestBody Request<SysDict> request){
        SysDict sysPost = request.getData();
        return sysDictService.save(sysPost)==true?Response.ok(sysPost.getId()):Response.fail();
    }


    @Operation(summary = "编辑")
    @PostMapping("/edit")
    public Response<Boolean> edit(@RequestBody Request<SysDict> request){
        SysDict sysDict = request.getData();
        return Response.ok(sysDictService.saveOrUpdate(sysDict));
    }


    @Operation(summary = "通过主键删除数据")
    @PostMapping("/deleteById")
    public Response<Boolean> deleteById(@RequestBody Request<String> request){
        return Response.ok(sysDictService.removeById(request.getData()));
    }


    @Operation(summary = "获取字典类型列表")
    @PostMapping("/getDictList")
    public Response<Page<SysDict>> getDictList(@RequestBody Request<SysDict> request){
        return Response.ok(sysDictService.getDictList(request));
    }

    @Operation(summary = "获取字段数据列表")
    @PostMapping("/getDictDataList")
    public Response<Page<SysDictData>> getDictDataList(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.getDictDataList(request));
    }

    @Operation(summary = "添加字典数据")
    @PostMapping("/addDictData")
    public Response<Boolean> addDictData(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.addDictData(request.getData()));
    }

    @Operation(summary = "更新字典数据")
    @PostMapping("/updateDictData")
    public Response<Boolean> updateDictData(@RequestBody Request<SysDictData> request){
        return Response.ok(sysDictService.updateDictData(request.getData()));
    }


    @Operation(summary = "通过字典类型获取字典")
    @PostMapping("/getDictByDictType")
    public Response<SysDict> getDictByDictType(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getDictByDictType(request.getData()));
    }

    @Operation(summary = "通过字典类型获取字典数据")
    @PostMapping("/getDictDataByDictType")
    public Response<List<SysDictData>> getDictDataByDictType(@RequestBody Request<String> request){
        return Response.ok(sysDictService.getDictDataByDictType(request.getData()));
    }

}