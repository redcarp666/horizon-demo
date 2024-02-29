package org.redcarp.horizon.demo.system.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "岗位表", description = "")
@TableName("sys_post")
@Data
public class SysPost implements Serializable, Cloneable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键", notes = "")
	private String id;
	/**
	 * 岗位编码
	 */
	@ApiModelProperty(name = "岗位编码", notes = "")
	private String postCode;
	/**
	 * 岗位名称
	 */
	@ApiModelProperty(name = "岗位名称", notes = "")
	private String postName;
	/**
	 * 排序
	 */
	@ApiModelProperty(name = "排序", notes = "")
	private Integer sort;
	/**
	 * 状态
	 */
	@ApiModelProperty(name = "状态", notes = "")
	private Integer status;
	/**
	 * 备注
	 */
	@ApiModelProperty(name = "备注", notes = "")
	private String remark;
	/**
	 * 删除
	 */
	@ApiModelProperty(name = "删除", notes = "")
	private Integer deleted;
	/**
	 * 租户号
	 */
	@ApiModelProperty(name = "租户号", notes = "")
	private String tenantId;
	/**
	 * 创建人
	 */
	@ApiModelProperty(name = "创建人", notes = "")
	private String createBy;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "创建时间", notes = "")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date createTime;
	/**
	 * 更新人
	 */
	@ApiModelProperty(name = "更新人", notes = "")
	private String updateBy;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "更新时间", notes = "")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private Date updateTime;

}