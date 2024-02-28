package org.redcarp.module.system.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
	@ApiModelProperty(name = "主键", notes = "")
	@TableId(type = IdType.ASSIGN_UUID)
	private String id;
	/**
	 * 用户账号
	 */
	@ApiModelProperty(name = "用户账号", notes = "")
	private String userName;
	/**
	 * 用户昵称
	 */
	@ApiModelProperty(name = "用户昵称", notes = "")
	private String userDisplayName;
	/**
	 * 部门id
	 */
	@ApiModelProperty(name = "部门id", notes = "")
	private String deptId;
	/**
	 * 用户邮箱
	 */
	@ApiModelProperty(name = "用户邮箱", notes = "")
	private String email;
	/**
	 * 手机号码
	 */
	@ApiModelProperty(name = "手机号码", notes = "")
	private String phone;
	/**
	 * 性别
	 */
	@ApiModelProperty(name = "性别", notes = "")
	private Integer sex;
	/**
	 * 用户密码
	 */
	@ApiModelProperty(name = "用户密码", notes = "")
	@JsonIgnore
	private String password;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态", notes = "")
	private String status;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "备注", notes = "")
	private String remark;
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
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
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
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date updateTime;
}