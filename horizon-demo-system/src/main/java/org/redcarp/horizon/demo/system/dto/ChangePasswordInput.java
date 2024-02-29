package org.redcarp.horizon.demo.system.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author redcarp
 * @date 2024/2/26
 */
@Data
public class ChangePasswordInput {
	@NotBlank
	private String oldPassword;
	@NotBlank
	private String newPassword;
}
