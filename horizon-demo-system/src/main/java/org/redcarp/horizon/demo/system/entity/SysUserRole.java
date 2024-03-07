package org.redcarp.horizon.demo.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "用户角色关联表")
@TableName("sys_user_role")
@Data
public class SysUserRole implements Serializable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键")
	private String id;
	/**
	 * 用户id
	 */
	@ApiModelProperty(name = "用户id")
	private String userId;
	/**
	 * 角色id
	 */
	@ApiModelProperty(name = "角色id")
	private String roleId;
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
	private Date updateTime;
}