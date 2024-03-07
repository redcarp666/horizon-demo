package org.redcarp.horizon.demo.system.entity;


import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "部门表")
@TableName("sys_dept")
@Data
public class SysDept implements Serializable {
	/**
	 * 主键
	 */
	@TableId
	@ApiModelProperty(name = "主键")
	private String id;
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
	/**
	 * 创建人
	 */
	@ApiModelProperty(name = "创建人")
	private String createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "创建时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date createTime;
	/**
	 * 更新人
	 */
	@ApiModelProperty(name = "更新人")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "更新时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date updateTime;



}