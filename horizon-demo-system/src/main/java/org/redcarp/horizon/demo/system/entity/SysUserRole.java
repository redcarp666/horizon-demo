package org.redcarp.horizon.demo.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(name = "用户角色关联表")
@TableName("sys_user_role")
@Data
public class SysUserRole extends HorizonBaseEntity {

	/**
	 * 用户id
	 */
	@Schema(name = "用户id")
	private String userId;
	/**
	 * 角色id
	 */
	@Schema(name = "角色id")
	private String roleId;
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