package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "菜单表", description = "")
@TableName("sys_menu")
@Data
public class SysMenu implements Serializable, Cloneable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键", notes = "")
	@TableId
	private String id;
	/**
	 * 菜单名
	 */
	@ApiModelProperty(name = "菜单名", notes = "")
	private String menuName;
	/**
	 * 父菜单ID
	 */
	@ApiModelProperty(name = "父菜单ID", notes = "")
	private String parentId;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "排序", notes = "")
	private Integer sort;
	/**
	 * 路由路径
	 */
	@ApiModelProperty(name = "路由路径", notes = "")
	private String path;
	/**
	 * 组件路径
	 */
	@ApiModelProperty(name = "组件路径", notes = "")
	private String component;
	/**
	 * 路由参数
	 */
	@ApiModelProperty(name = "路由参数", notes = "")
	private String query;
	/**
	 * 是否外链
	 */
	@ApiModelProperty(name = "是否外链", notes = "")
	private String isFrame;
	/**
	 * 菜单类型;菜单类型（0目录 1菜单 2按钮）
	 */
	@ApiModelProperty(name = "菜单类型", notes = "菜单类型（0目录 1菜单 2按钮）")
	private Integer menuType;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态", notes = "")
	private Integer status;
	/**
	 * 权限标识
	 */
	@ApiModelProperty(name = "权限标识", notes = "")
	private String permission;
	/**
	 * 图标
	 */
	@ApiModelProperty(name = "图标", notes = "")
	private String icon;
	/**
	 * 删除
	 */
	@ApiModelProperty(name = "删除", notes = "")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@ApiModelProperty(name = "租户号", notes = "")
	private String tenantId;
	/**
	 * 创建人
	 */
	@ApiModelProperty(name = "创建人", notes = "")
	private String createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "创建时间", notes = "")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createTime;
	/**
	 * 更新人
	 */
	@ApiModelProperty(name = "更新人", notes = "")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "更新时间", notes = "")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date updateTime;


}