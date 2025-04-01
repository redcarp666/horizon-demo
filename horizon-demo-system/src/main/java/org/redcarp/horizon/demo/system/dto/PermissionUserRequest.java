package org.redcarp.horizon.demo.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PermissionUserRequest {

    @Schema(description = "角色id")
    private String roleId;
    @Schema(description = "用户id")
    private List<String> permissionList;

}
