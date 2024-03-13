package org.redcarp.horizon.demo.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.redcarp.horizon.demo.system.entity.SysUser;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

	Page<SysUser> getList(Page<SysUser> page, @Param("condition") SysUser sysUser);

}