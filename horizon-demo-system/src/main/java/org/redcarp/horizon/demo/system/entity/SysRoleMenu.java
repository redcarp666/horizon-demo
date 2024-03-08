package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;

/**
 * 角色菜单关联表;
 *
 * @date : 2023-12-6
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "角色菜单关联表")
@TableName("sys_role_menu")
@Data
public class SysRoleMenu extends HorizonBaseEntity {

	/**
	 * 菜单id
	 */
	@ApiModelProperty(name = "菜单id")
	private String menuId;
	/**
	 * 角色id
	 */
	@ApiModelProperty(name = "角色id")
	private String roleId;
	/**
	 * 权限标识
	 */
	@ApiModelProperty(name = "权限标识")
	private String permission;
	/**
	 * 删除
	 */
	@ApiModelProperty(name = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@ApiModelProperty(name = "租户号")
	private String tenantId;

}