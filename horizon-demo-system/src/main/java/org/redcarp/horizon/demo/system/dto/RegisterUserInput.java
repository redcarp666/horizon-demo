package org.redcarp.horizon.demo.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author redcarp
 * @date 2024/2/20
 */
@Data
public class RegisterUserInput {
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
	private String password;
}
