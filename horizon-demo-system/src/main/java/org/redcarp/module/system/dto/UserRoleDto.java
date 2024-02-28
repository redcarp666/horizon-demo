package org.redcarp.module.system.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户的所有角色
 *
 * @author redcarp
 * @date 2024/2/21
 */
@Data
public class UserRoleDto {
	private String userId;
	private List<String> roleNames = new ArrayList<>();

}
