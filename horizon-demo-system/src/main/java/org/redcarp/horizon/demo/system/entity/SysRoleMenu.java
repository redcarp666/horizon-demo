package org.redcarp.horizon.demo.system.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色菜单关联表;
 *
 * @date : 2023-12-6
 */
@ApiModel(value = "角色菜单关联表")
@TableName("sys_role_menu")
@Data
public class SysRoleMenu implements Serializable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键")
	@TableId
	private String id;
	/**
	 * 菜单id
	 */
	@ApiModelProperty(name = "菜单id")
	private String menuId;
	/**
	 * 角色id
	 */
	@ApiModelProperty(name = "角色id")
	private String roleId;
	/**
	 * 权限标识
	 */
	@ApiModelProperty(name = "权限标识")
	private String permission;
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
	/**
	 * 创建人
	 */
	@ApiModelProperty(name = "创建人")
	private String createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "创建时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date createTime;
	/**
	 * 更新人
	 */
	@ApiModelProperty(name = "更新人")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "更新时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date updateTime;
}