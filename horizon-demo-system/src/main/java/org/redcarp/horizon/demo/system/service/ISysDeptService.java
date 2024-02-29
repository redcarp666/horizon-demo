package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.core.datastructure.Tree;
import org.redcarp.horizon.demo.system.entity.SysDept;


public interface ISysDeptService extends IService<SysDept> {
	Tree<SysDept> getDeptTree();

	Boolean refreshDeptTree();
}
