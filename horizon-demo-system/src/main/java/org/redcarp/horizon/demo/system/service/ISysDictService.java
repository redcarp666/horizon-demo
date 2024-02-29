package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.common.base.domain.Request;
import org.redcarp.horizon.demo.system.entity.SysDict;
import org.redcarp.horizon.demo.system.entity.SysDictData;

import java.util.List;

public interface ISysDictService extends IService<SysDict> {

    Page<SysDict> getDictList(Request<SysDict> request);

    Page<SysDictData> getDictDataList(Request<SysDictData> request);

    Boolean addDictData(SysDictData sysDictData);
    Boolean updateDictData(SysDictData sysDictData);
    SysDict getDictByDictType(String dictType);
    List<SysDictData> getDictDataByDictType(String dictType);
}
