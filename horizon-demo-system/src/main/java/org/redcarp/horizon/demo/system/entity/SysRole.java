package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;

/**
 * 角色表;
 *
 * @date : 2023-12-6
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "角色表")
@TableName("sys_role")
@Data
public class SysRole extends HorizonBaseEntity {


	/**
	 * 角色名
	 */
	@Schema(description = "角色名")
	private String roleName;
	/**
	 * 排序
	 */
	@Schema(description = "排序")
	private Integer sort;
	/**
	 * 状态
	 */
	@Schema(description = "状态")
	private Integer status;
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