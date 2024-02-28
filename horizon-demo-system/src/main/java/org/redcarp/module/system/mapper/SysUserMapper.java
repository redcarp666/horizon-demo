package org.redcarp.module.system.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.redcarp.common.base.domain.Request;
import org.redcarp.module.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper  extends BaseMapper<SysUser>{

    List<SysUser> getList(Page page,@Param("condition") SysUser sysUser);

}