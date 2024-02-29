package org.redcarp.horizon.demo.system.dto;

import org.redcarp.horizon.demo.system.entity.SysMenu;
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
