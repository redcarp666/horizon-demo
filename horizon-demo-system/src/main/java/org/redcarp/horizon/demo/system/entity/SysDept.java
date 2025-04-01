package org.redcarp.horizon.demo.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@Schema(name = "部门表")
@TableName("sys_dept")
@Data
public class SysDept extends HorizonBaseEntity {

	/**
	 * 上级部门
	 */
	@Schema(name = "上级部门")
	private String parentId;
	/**
	 * 部门名称
	 */
	@Schema(name = "部门名称")
	private String deptName;
	/**
	 * 排序
	 */
	@Schema(name = "排序")
	private Integer sort;
	/**
	 * 负责人
	 */
	@Schema(name = "负责人")
	private String leader;
	/**
	 * 部门联系电话
	 */
	@Schema(name = "部门联系电话")
	private String phone;
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