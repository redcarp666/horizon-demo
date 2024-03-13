package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.horizon.infrastructure.domain.Request;
import org.redcarp.horizon.demo.system.dto.RegisterUserInput;
import org.redcarp.horizon.demo.system.entity.SysUser;

import java.util.List;

public interface ISysUserService extends IService<SysUser> {

	SysUser changePassword(String username, String newEncodedPassword);

	SysUser getByUsername(String userName);

	String register(RegisterUserInput input);

	Page<SysUser> getList(Request<SysUser> request);

}
