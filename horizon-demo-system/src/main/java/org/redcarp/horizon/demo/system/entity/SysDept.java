package org.redcarp.horizon.demo.system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.redcarp.horizon.infrastructure.domain.HorizonBaseEntity;


@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "部门表")
@TableName("sys_dept")
@Data
public class SysDept extends HorizonBaseEntity {

	/**
	 * 上级部门
	 */
	@ApiModelProperty(name = "上级部门")
	private String parentId;
	/**
	 * 部门名称
	 */
	@ApiModelProperty(name = "部门名称")
	private String deptName;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "排序")
	private Integer sort;
	/**
	 * 负责人
	 */
	@ApiModelProperty(name = "负责人")
	private String leader;
	/**
	 * 部门联系电话
	 */
	@ApiModelProperty(name = "部门联系电话")
	private String phone;
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