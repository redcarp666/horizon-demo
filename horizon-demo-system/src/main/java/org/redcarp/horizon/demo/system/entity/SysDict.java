package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "字典类型表")
@TableName("sys_dict")
@Data
public class SysDict extends HorizonBaseEntity {


	/**
	 * 字典名
	 */
	@ApiModelProperty(name = "字典名")
	private String dictName;
	/**
	 * 字典类型
	 */
	@ApiModelProperty(name = "字典类型")
	private String dictType;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态")
	private Integer status;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "备注")
	private String remark;
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