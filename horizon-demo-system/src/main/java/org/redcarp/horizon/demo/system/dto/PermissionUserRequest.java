package org.redcarp.horizon.demo.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PermissionUserRequest {

    @Schema(name = "角色id")
    private String roleId;
    @Schema(name = "用户id")
    private List<String> permissionList;

}
