package org.redcarp.horizon.demo.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.redcarp.horizon.common.base.constant.RedisConstants;
import org.redcarp.horizon.component.redis.RedisService;
import org.redcarp.horizon.core.datastructure.Tree;
import org.redcarp.horizon.demo.system.entity.SysDept;
import org.redcarp.horizon.demo.system.mapper.SysDeptMapper;
import org.redcarp.horizon.demo.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {


	@Autowired
	RedisService redisService;


	@Override
	public Tree<SysDept> getDeptTree() {
		Tree<SysDept> tree = redisService.get(RedisConstants.DEPT_TREE_GLOBAL_PREFIX, Tree.class);

		if (null != tree) {
			return tree;
		}
		List<SysDept> sysDeptList = this.list();
		String rootId = sysDeptList.stream().filter(o -> StrUtil.isEmpty(o.getParentId())).findFirst().get().getId();
		tree = getDeptTree(sysDeptList, rootId);
		return tree;
	}

	@Override
	public Boolean refreshDeptTree() {
		redisService.del(RedisConstants.DEPT_TREE_GLOBAL_PREFIX);
		return true;
	}

	private Tree<SysDept> getDeptTree(List<SysDept> sysDeptList, String id) {
		Tree<SysDept> tree = new Tree<>();
		SysDept dept = sysDeptList.stream().filter(o -> StrUtil.equals(id, o.getId())).findFirst().get();
		tree.setId(dept.getId());
		tree.setName(dept.getDeptName());
		tree.setParentId(dept.getParentId());
		tree.setData(dept);
		List<Tree<SysDept>> treeChildren = Lists.newArrayList();
		List<SysDept> subDeptList = sysDeptList.stream().filter(o -> StrUtil.equals(id, o.getParentId())).collect(
				Collectors.toList());
		for (SysDept subDept : subDeptList) {
			Tree<SysDept> deptTree = getDeptTree(sysDeptList, subDept.getId());
			treeChildren.add(deptTree);
		}
		tree.setChildren(treeChildren.isEmpty() ? null : treeChildren);
		return tree;
	}


}
