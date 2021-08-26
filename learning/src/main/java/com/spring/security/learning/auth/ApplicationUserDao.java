package com.spring.security.learning.auth;

import java.util.Optional;

public interface ApplicationUserDao {
	public Optional<ApplicationUser> selectApplicationUSerByUserName(String username);
}
