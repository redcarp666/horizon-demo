package org.redcarp.horizon.demo.system.service.impl;


import org.redcarp.horizon.common.base.utils.PreconditionUtils;
import org.redcarp.horizon.security.jwt.AbstractSecurityManager;
import org.redcarp.horizon.security.jwt.handler.BlacklistHandler;
import org.redcarp.horizon.security.jwt.handler.CurrentUserHolder;
import org.redcarp.horizon.security.jwt.token.JwtTokens;
import org.redcarp.horizon.core.util.MapUtils;
import org.redcarp.horizon.demo.system.entity.SysUser;
import org.redcarp.horizon.demo.system.service.ISysUserRoleService;
import org.redcarp.horizon.demo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author redcarp
 * @date 2024/2/24
 */
@Service
public class SysUserSecurityManager extends AbstractSecurityManager {

	@Autowired
	ISysUserService userService;
	@Autowired
	JwtTokens jwtTokens;
	@Autowired
	ISysUserRoleService userRoleService;
	@Autowired
	BlacklistHandler blacklistHandler;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = userService.getByUsername(username);
		PreconditionUtils.requireNotNull(sysUser, "user.null.error");
		return new User(sysUser.getUserName(), sysUser.getPassword(), new ArrayList<>());
	}

	@Override
	protected Jwt generateJwt(Authentication authentication) {
		return getAccessTokenByUsername(authentication.getName());
	}

	@Override
	protected void updatePassword(String userName, String newEncodedPassword) {
		userService.changePassword(userName, newEncodedPassword);
	}

	@Override
	protected void loginSucceed() {
		blacklistHandler.delFromBlacklist(CurrentUserHolder.getCurrentUserId());
	}

	@Override
	protected void passwordChangeSucceed() {
		blacklistHandler.addToBlacklist(CurrentUserHolder.getCurrentUserId());
	}

	public Jwt getAccessTokenByUsername(String username) {
		SysUser sysUser = userService.getByUsername(username);
		return getNewJwt(sysUser);
	}

	public Jwt getAccessTokenByUserId(String userId) {
		SysUser sysUser = userService.getById(userId);
		return getNewJwt(sysUser);
	}


	public Map<String, Object> response(Jwt accessToken) {
		Map<String, Object> result = new HashMap<>();
		if (accessToken != null) {
			String subject = accessToken.getSubject();
			result.put("user",
			           MapUtils.linkedHashMapOf("id",
			                                    subject,
			                                    "name",
			                                    accessToken.getClaimAsString("name"),
			                                    "roles",
			                                    accessToken.getClaimAsStringList("roles")));
			result.put("token", accessToken.getTokenValue());
			result.put("tokenExpiresIn", accessToken.getExpiresAt());
			result.put("refreshToken", jwtTokens.generateJwtRefreshToken(subject, null).getTokenValue());
		}
		return result;
	}

	private Jwt getNewJwt(SysUser sysUser) {
		PreconditionUtils.requireNotNull(sysUser, "user.null.error");
		List<String> roleNames = userRoleService.getRoles(sysUser.getId()).getRoleNames();
		return jwtTokens.generateJwtToken(sysUser.getId(), claimMap -> {
			claimMap.put("roles", roleNames);
			claimMap.put("name", sysUser.getUserName());
		});
	}


}
