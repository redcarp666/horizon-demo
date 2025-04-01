package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(description = "字典数据表")
@TableName("sys_dict_data")
@Data
public class SysDictData extends HorizonBaseEntity {

	/**
	 * 字典编码
	 */
	@Schema(description = "字典编码")
	private String dictCode;
	/**
	 * 字典标签
	 */
	@Schema(description = "字典标签")
	private String dictLabel;
	/**
	 * 字典键值
	 */
	@Schema(description = "字典键值")
	private String dictValue;
	/**
	 * 字典类型
	 */
	@Schema(description = "字典类型")
	private String dictType;
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
	 * 备注
	 */
	@Schema(description = "备注")
	private String remark;
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