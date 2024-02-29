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


@ApiModel(value = "字典数据表", description = "")
@TableName("sys_dict_data")
@Data
public class SysDictData implements Serializable, Cloneable {
	/**
	 * 主键
	 */
	@ApiModelProperty(name = "主键", notes = "")
	private String id;
	/**
	 * 字典编码
	 */
	@ApiModelProperty(name = "字典编码", notes = "")
	private String dictCode;
	/**
	 * 字典标签
	 */
	@ApiModelProperty(name = "字典标签", notes = "")
	private String dictLabel;
	/**
	 * 字典键值
	 */
	@ApiModelProperty(name = "字典键值", notes = "")
	private String dictValue;
	/**
	 * 字典类型
	 */
	@ApiModelProperty(name = "字典类型", notes = "")
	private String dictType;
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