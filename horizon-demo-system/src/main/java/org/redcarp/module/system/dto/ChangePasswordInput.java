package org.redcarp.module.system.dto;

import lombok.Data;

/**
 * @author redcarp
 * @date 2024/2/26
 */
@Data
public class ChangePasswordInput {
	private String oldPassword;
	private String newPassword;
}
