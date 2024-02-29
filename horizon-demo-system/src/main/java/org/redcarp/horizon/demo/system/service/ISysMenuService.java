package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.demo.system.entity.SysMenu;
import org.redcarp.horizon.core.datastructure.Tree;

public interface ISysMenuService extends IService<SysMenu> {


	Tree<SysMenu> getMenuTree();

	Boolean refreshMenuTree();

	Tree<SysMenu> getUserMenuTree();
}
