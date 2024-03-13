package org.redcarp.horizon.demo.test;

import org.redcarp.horizon.infrastructure.domain.Response;
import org.redcarp.horizon.security.jwt.handler.CurrentUserHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author redcarp
 * @date 2024/3/13
 */
@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/hello")
	@PreAuthorize("isAuthenticated()")
	public Response<String> helloWorld() {
		String userName = CurrentUserHolder.getCurrentUserName();
		return Response.ok("hello," + userName);
	}
}
