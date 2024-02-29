package org.redcarp.horizon.demo.system.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PermissionUserRequest {

    @ApiModelProperty("角色id")
    private String roleId;
    @ApiModelProperty("用户id")
    private List<String> permissionList;

}
