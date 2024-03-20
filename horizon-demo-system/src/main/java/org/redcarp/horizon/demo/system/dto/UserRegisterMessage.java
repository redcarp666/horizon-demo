package org.redcarp.horizon.demo.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author redcarp
 * @date 2024/3/19
 */
@Data
@AllArgsConstructor
public class UserRegisterMessage implements Serializable {
	private String id;
	private Integer sex;
}
