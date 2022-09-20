package org.magm.backend.controllers;

import org.magm.backend.auth.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseRestController {
	protected User getUserLogged() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return user;
	}
}
