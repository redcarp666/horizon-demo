package org.redcarp.horizon.demo.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetPermissionRequest {
    @Schema(name = "角色id")
    private String roleId;
}
