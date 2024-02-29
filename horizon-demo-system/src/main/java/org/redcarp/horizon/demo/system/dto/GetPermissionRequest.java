package org.redcarp.horizon.demo.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GetPermissionRequest {
    @ApiModelProperty("角色id")
    private String roleId;
}
