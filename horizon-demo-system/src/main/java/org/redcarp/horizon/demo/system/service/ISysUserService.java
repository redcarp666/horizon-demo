package org.redcarp.horizon.demo.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.redcarp.common.base.domain.Request;
import org.redcarp.horizon.demo.system.dto.RegisterUserInput;
import org.redcarp.horizon.demo.system.entity.SysUser;

import java.util.List;

public interface ISysUserService extends IService<SysUser> {

	SysUser changePassword(String username, String newEncodedPassword);

	SysUser getByUsername(String userName);

	String register(RegisterUserInput input);

	List<SysUser> getList(Request<SysUser> request);

}
