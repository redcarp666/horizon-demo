package org.redcarp.horizon.demo.system.service.impl;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redcarp.common.base.domain.Request;
import org.redcarp.horizon.demo.system.service.ISysDictDataService;
import org.redcarp.horizon.demo.system.entity.SysDict;
import org.redcarp.horizon.demo.system.entity.SysDictData;
import org.redcarp.horizon.demo.system.mapper.SysDictMapper;
import org.redcarp.horizon.demo.system.service.ISysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

	@Autowired
	ISysDictDataService sysDictDataService;

	@Override
	public Page<SysDict> getDictList(Request<SysDict> request) {
		SysDict sysDict = request.getData();
		LambdaQueryWrapper<SysDict> wrapper = Wrappers.lambdaQuery(SysDict.class);
		wrapper.eq(ObjectUtil.isNotNull(sysDict.getDictType()), SysDict::getDictType, sysDict.getDictType());
		wrapper.eq(ObjectUtil.isNotNull(sysDict.getDictName()), SysDict::getDictName, sysDict.getDictName());
		wrapper.eq(ObjectUtil.isNotNull(sysDict.getStatus()), SysDict::getStatus, sysDict.getStatus());
		return this.page(request.getPage(), wrapper);
	}

	@Override
	public Page<SysDictData> getDictDataList(Request<SysDictData> request) {
		SysDictData sysDictData = request.getData();
		LambdaQueryWrapper<SysDictData> wrapper = Wrappers.lambdaQuery(SysDictData.class);
		wrapper.eq(ObjectUtil.isNotNull(sysDictData.getDictLabel()),
		           SysDictData::getDictLabel,
		           sysDictData.getDictLabel());
		wrapper.eq(ObjectUtil.isNotNull(sysDictData.getStatus()), SysDictData::getStatus, sysDictData.getStatus());
		return sysDictDataService.page(request.getPage(), wrapper);
	}


	@Override
	public Boolean addDictData(SysDictData sysDictData) {
		return sysDictDataService.save(sysDictData);
	}

	@Override
	public Boolean updateDictData(SysDictData sysDictData) {
		return sysDictDataService.saveOrUpdate(sysDictData);
	}

	@Override
	public SysDict getDictByDictType(String dictType) {
		return this.getOne(Wrappers.lambdaQuery(SysDict.class).eq(SysDict::getDictType, dictType));
	}

	@Override
	public List<SysDictData> getDictDataByDictType(String dictType) {
		return sysDictDataService.list(Wrappers.lambdaQuery(SysDictData.class).eq(SysDictData::getDictType, dictType));
	}


}
