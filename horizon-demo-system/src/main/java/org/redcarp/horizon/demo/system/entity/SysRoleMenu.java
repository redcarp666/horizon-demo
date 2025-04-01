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
@Schema(name = "角色菜单关联表")
@TableName("sys_role_menu")
@Data
public class SysRoleMenu extends HorizonBaseEntity {

	/**
	 * 菜单id
	 */
	@Schema(name = "菜单id")
	private String menuId;
	/**
	 * 角色id
	 */
	@Schema(name = "角色id")
	private String roleId;
	/**
	 * 权限标识
	 */
	@Schema(name = "权限标识")
	private String permission;
	/**
	 * 删除
	 */
	@Schema(name = "删除")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@Schema(name = "租户号")
	private String tenantId;

}