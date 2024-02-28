package org.redcarp.module.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.redcarp.common.base.domain.Request;
import org.redcarp.common.base.utils.PreconditionUtils;
import org.redcarp.component.redis.RedisService;
import org.redcarp.module.system.dto.RegisterUserInput;
import org.redcarp.module.system.entity.SysUser;
import org.redcarp.module.system.mapper.SysUserMapper;
import org.redcarp.module.system.service.ISysUserRoleService;
import org.redcarp.module.system.service.ISysUserService;
import org.redcarp.security.shared.configuration.PasswordEncoderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


	@Autowired
	ISysUserRoleService sysUserRoleService;
	@Autowired
	RedisService redisService;


	@Override
	public SysUser changePassword(String username, String newEncodedPassword) {
		SysUser sysUser = getByUsername(username);
		sysUser.setPassword(newEncodedPassword);
		updateById(sysUser);
		return sysUser;
	}

	@Override
	public SysUser getByUsername(String userName) {
		return getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUserName, userName), false);
	}

	@Override
	public String register(RegisterUserInput input) {
		checkDuplicateUserName(input.getUserName());
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(input, sysUser);
		sysUser.setPassword(PasswordEncoderService.getPasswordEncoder().encode(input.getPassword()));
		save(sysUser);
		return sysUser.getId();
	}

	@Override
	public List<SysUser> getList(Request<SysUser> request) {
		return this.getBaseMapper().getList(request.getPage(), request.getData());
	}


	/**
	 * 用户名唯一检查
	 *
	 * @param userName 用户名
	 * @author redcarp
	 * @date 2024/2/20
	 */
	private void checkDuplicateUserName(String userName) {
		SysUser sysUser = getByUsername(userName);
		PreconditionUtils.requireNull(sysUser, "user.name.exist.error");
	}
}
