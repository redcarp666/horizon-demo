package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(name = "菜单表")
@TableName("sys_menu")
@Data
public class SysMenu extends HorizonBaseEntity {

	/**
	 * 菜单名
	 */
	@Schema(name = "菜单名")
	private String menuName;
	/**
	 * 父菜单ID
	 */
	@Schema(name = "父菜单ID")
	private String parentId;
	/**
	 * 排序
	 */
	@Schema(name = "排序")
	private Integer sort;
	/**
	 * 路由路径
	 */
	@Schema(name = "路由路径")
	private String path;
	/**
	 * 组件路径
	 */
	@Schema(name = "组件路径")
	private String component;
	/**
	 * 路由参数
	 */
	@Schema(name = "路由参数")
	private String query;
	/**
	 * 是否外链
	 */
	@Schema(name = "是否外链")
	private String isFrame;
	/**
	 * 菜单类型;菜单类型（0目录 1菜单 2按钮）
	 */
	@Schema(name = "菜单类型")
	private Integer menuType;
	/**
	 * 状态
	 */
	@Schema(name = "状态")
	private Integer status;
	/**
	 * 权限标识
	 */
	@Schema(name = "权限标识")
	private String permission;
	/**
	 * 图标
	 */
	@Schema(name = "图标")
	private String icon;
	/**
	 * 删除
	 */
	@Schema(name = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@Schema(name = "租户号")
	private String tenantId;
	


}