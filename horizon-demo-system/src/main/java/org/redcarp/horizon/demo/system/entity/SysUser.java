package org.redcarp.horizon.demo.system.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "用户表")
@TableName("sys_user")
@Data
public class SysUser implements Serializable {

	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键")
	@TableId(type = IdType.ASSIGN_UUID)
	private String id;
	/**
	 * 用户账号
	 */
	@ApiModelProperty(name = "用户账号")
	private String userName;
	/**
	 * 用户昵称
	 */
	@ApiModelProperty(name = "用户昵称")
	private String userDisplayName;
	/**
	 * 部门id
	 */
	@ApiModelProperty(name = "部门id")
	private String deptId;
	/**
	 * 用户邮箱
	 */
	@ApiModelProperty(name = "用户邮箱")
	private String email;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(name = "手机号码")
	private String phone;
	/**
	 * 性别
	 */
	@ApiModelProperty(name = "性别")
	private Integer sex;
	/**
	 * 用户密码
	 */
	@ApiModelProperty(name = "用户密码")
	@JsonIgnore
	private String password;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态")
	private String status;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "备注")
	private String remark;
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
	@TableField(fill = FieldFill.INSERT)
	private String createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "创建时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 更新人
	 */
	@ApiModelProperty(name = "更新人")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "更新时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
}