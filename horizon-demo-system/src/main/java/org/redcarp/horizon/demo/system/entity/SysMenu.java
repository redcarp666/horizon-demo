package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "菜单表")
@TableName("sys_menu")
@Data
public class SysMenu extends HorizonBaseEntity {

	/**
	 * 菜单名
	 */
	@ApiModelProperty(name = "菜单名")
	private String menuName;
	/**
	 * 父菜单ID
	 */
	@ApiModelProperty(name = "父菜单ID")
	private String parentId;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "排序")
	private Integer sort;
	/**
	 * 路由路径
	 */
	@ApiModelProperty(name = "路由路径")
	private String path;
	/**
	 * 组件路径
	 */
	@ApiModelProperty(name = "组件路径")
	private String component;
	/**
	 * 路由参数
	 */
	@ApiModelProperty(name = "路由参数")
	private String query;
	/**
	 * 是否外链
	 */
	@ApiModelProperty(name = "是否外链")
	private String isFrame;
	/**
	 * 菜单类型;菜单类型（0目录 1菜单 2按钮）
	 */
	@ApiModelProperty(name = "菜单类型", notes = "菜单类型（0目录 1菜单 2按钮）")
	private Integer menuType;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态")
	private Integer status;
	/**
	 * 权限标识
	 */
	@ApiModelProperty(name = "权限标识")
	private String permission;
	/**
	 * 图标
	 */
	@ApiModelProperty(name = "图标")
	private String icon;
	/**
	 * 删除
	 */
	@ApiModelProperty(name = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@ApiModelProperty(name = "租户号")
	private String tenantId;
	


}