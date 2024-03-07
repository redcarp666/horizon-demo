package org.redcarp.horizon.demo.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redcarp.horizon.infrastructure.domain.Response;
import org.redcarp.horizon.demo.system.service.impl.SysUserSecurityManager;
import org.redcarp.horizon.security.shared.auth.LoginUsernamePassword;
import org.redcarp.horizon.demo.system.dto.ChangePasswordInput;
import org.redcarp.horizon.demo.system.dto.LoginInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author redcarp
 * @date 2024/2/26
 */
@Api(tags = "认证管理")
@RestController
@RequestMapping("/security")
@Slf4j
public class SysUserSecurityController {


	@Autowired
	private SysUserSecurityManager sysUserSecurityManager;

	@PostMapping("/login")
	@ApiOperation("登录")
	public Response<Map<String, Object>> login(@RequestBody LoginInput input) {
		Jwt accessToken = sysUserSecurityManager.login(new LoginUsernamePassword(input.getUserName(),
		                                                                         input.getPassword()));
		return Response.ok(sysUserSecurityManager.response(accessToken));
	}

	@GetMapping("/refreshToken")
	public Response<Map<String, Object>> refreshToken() {
		return Response.ok(sysUserSecurityManager.response(sysUserSecurityManager.getAccessTokenByUserId(
				SecurityContextHolder.getContext().getAuthentication().getName())));
	}

	@PostMapping("/changePassword")
	public Response<Object> changePassword(@RequestBody @Validated ChangePasswordInput input) {
		sysUserSecurityManager.changePassword(input.getOldPassword(), input.getNewPassword());
		return Response.ok();
	}

}
