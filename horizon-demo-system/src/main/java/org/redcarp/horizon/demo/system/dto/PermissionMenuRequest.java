package org.redcarp.horizon.demo.system.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.redcarp.horizon.demo.system.entity.SysMenu;

import java.util.List;

@Data
public class PermissionMenuRequest {

    @Schema(description = "角色id")
    private String roleId;
    @Schema(description = "授权菜单")
    private List<SysMenu> permissionList;

}
