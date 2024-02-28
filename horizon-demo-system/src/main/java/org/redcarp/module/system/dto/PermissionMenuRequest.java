package org.redcarp.module.system.dto;

import org.redcarp.module.system.entity.SysMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PermissionMenuRequest {

    @ApiModelProperty("角色id")
    private String roleId;
    @ApiModelProperty("授权菜单")
    private List<SysMenu> permissionList;

}
