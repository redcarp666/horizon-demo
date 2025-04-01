package org.redcarp.horizon.demo.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(description = "岗位表")
@TableName("sys_post")
@Data
public class SysPost extends HorizonBaseEntity {
	/**
	 * 岗位编码
	 */
	@Schema(description = "岗位编码")
	private String postCode;
	/**
	 * 岗位名称
	 */
	@Schema(description = "岗位名称")
	private String postName;
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