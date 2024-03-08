package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;

/**
 * 角色表;
 *
 * @date : 2023-12-6
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "角色表")
@TableName("sys_role")
@Data
public class SysRole extends HorizonBaseEntity {


	/**
	 * 角色名
	 */
	@ApiModelProperty(name = "角色名")
	private String roleName;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "排序")
	private Integer sort;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态")
	private Integer status;
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