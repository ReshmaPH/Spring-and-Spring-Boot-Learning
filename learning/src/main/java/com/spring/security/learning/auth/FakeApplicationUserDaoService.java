package com.spring.security.learning.auth;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.spring.security.learning.security.ApplicationUserRole;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUser> selectApplicationUSerByUserName(String username) {
		return getApplicationUSers().stream()
							.filter(applicationUser->username.equals(applicationUser.getUsername()))
							.findFirst();
	}
	

	public List<ApplicationUser> getApplicationUSers(){
		List<ApplicationUser> applicationUsers=Lists.newArrayList(new ApplicationUser(
					"Resh",
					passwordEncoder.encode("password"),
					ApplicationUserRole.STUDENT.getGrantedAuthorities(),
					true,
					true,
					true,
					true
					) ,
				new ApplicationUser(
						"Lohi",
						passwordEncoder.encode("password1234"),
						ApplicationUserRole.ADMIN.getGrantedAuthorities(),
						true,
						true,
						true,
						true
						),
				new ApplicationUser(
						"Risha",
						passwordEncoder.encode("password123"),
						ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
						true,
						true,
						true,
						true
						));
		return applicationUsers;
	}
}
