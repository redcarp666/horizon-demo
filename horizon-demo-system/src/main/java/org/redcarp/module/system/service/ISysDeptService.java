package org.redcarp.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.core.datastructure.Tree;
import org.redcarp.module.system.entity.SysDept;


public interface ISysDeptService extends IService<SysDept> {
	Tree<SysDept> getDeptTree();

	Boolean refreshDeptTree();
}
