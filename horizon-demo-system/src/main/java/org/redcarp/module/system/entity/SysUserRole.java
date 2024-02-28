package org.redcarp.module.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "用户角色关联表", description = "")
@TableName("sys_user_role")
@Data
public class SysUserRole implements Serializable, Cloneable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键", notes = "")
	private String id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "用户id", notes = "")
	private String userId;
	/**
	 * 角色id
	 */
	@ApiModelProperty(name = "角色id", notes = "")
	private String roleId;
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
	private Date updateTime;
}