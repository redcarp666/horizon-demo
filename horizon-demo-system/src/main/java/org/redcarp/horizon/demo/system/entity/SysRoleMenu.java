package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;

/**
 * 角色菜单关联表;
 *
 * @date : 2023-12-6
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色菜单关联表")
@TableName("sys_role_menu")
@Data
public class SysRoleMenu extends HorizonBaseEntity {

	/**
	 * 菜单id
	 */
	@Schema(description = "菜单id")
	private String menuId;
	/**
	 * 角色id
	 */
	@Schema(description = "角色id")
	private String roleId;
	/**
	 * 权限标识
	 */
	@Schema(description = "权限标识")
	private String permission;
	/**
	 * 删除
	 */
	@Schema(description = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@Schema(description = "租户号")
	private String tenantId;

}