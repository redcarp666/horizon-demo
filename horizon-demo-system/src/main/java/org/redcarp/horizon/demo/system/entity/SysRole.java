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
@Schema(name = "角色表")
@TableName("sys_role")
@Data
public class SysRole extends HorizonBaseEntity {


	/**
	 * 角色名
	 */
	@Schema(name = "角色名")
	private String roleName;
	/**
	 * 排序
	 */
	@Schema(name = "排序")
	private Integer sort;
	/**
	 * 状态
	 */
	@Schema(name = "状态")
	private Integer status;
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