package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(name = "字典类型表")
@TableName("sys_dict")
@Data
public class SysDict extends HorizonBaseEntity {


	/**
	 * 字典名
	 */
	@Schema(name = "字典名")
	private String dictName;
	/**
	 * 字典类型
	 */
	@Schema(name = "字典类型")
	private String dictType;
	/**
	 * 状态
	 */
	@Schema(name = "状态")
	private Integer status;
	/**
	 * 备注
	 */
	@Schema(name = "备注")
	private String remark;
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