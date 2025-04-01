package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(description = "用户表")
@TableName("sys_user")
@Data
public class SysUser extends HorizonBaseEntity {

	/**
	 * 用户账号
	 */
	@Schema(description = "用户账号")
	private String userName;
	/**
	 * 用户昵称
	 */
	@Schema(description = "用户昵称")
	private String userDisplayName;
	/**
	 * 部门id
	 */
	@Schema(description = "部门id")
	private String deptId;
	/**
	 * 用户邮箱
	 */
	@Schema(description = "用户邮箱")
	private String email;
	/**
	 * 手机号码
	 */
	@Schema(description = "手机号码")
	private String phone;
	/**
	 * 性别
	 */
	@Schema(description = "性别")
	private Integer sex;
	/**
	 * 用户密码
	 */
	@Schema(description = "用户密码")
	@JsonIgnore
	private String password;
	/**
	 * 状态
	 */
	@Schema(description = "状态")
	private String status;
	/**
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;
	/**
	 * 删除
	 */
	@Schema(description = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@Schema(description = "租户号")
	private String tenantId;

}