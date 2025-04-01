package org.redcarp.horizon.demo.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
	private String password;
}
