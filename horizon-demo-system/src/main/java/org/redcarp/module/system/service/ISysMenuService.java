package org.redcarp.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.module.system.entity.SysMenu;
import org.redcarp.core.datastructure.Tree;

public interface ISysMenuService extends IService<SysMenu> {


	Tree<SysMenu> getMenuTree();

	Boolean refreshMenuTree();

	Tree<SysMenu> getUserMenuTree();
}
