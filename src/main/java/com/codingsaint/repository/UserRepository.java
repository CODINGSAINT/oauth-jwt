package com.codingsaint.repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.codingsaint.model.AppUser;

@Repository
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public AppUser getUserDetails(String userName) {
		String sql="SELECT * from USERS where username=?";
		List<AppUser> users= jdbcTemplate.query("SELECT * from USERS where username=?",
				new String[] { userName }, (ResultSet rs, int rowNum) -> {
			AppUser appUser = new AppUser();
			appUser.setUsername(userName);
			appUser.setPassword(rs.getString("PASSWORD"));
			return appUser;
				});
		if(users!=null && users.size()>0) {
			GrantedAuthority grantedAuthority= new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			grantedAuthorities.add(grantedAuthority);
			users.get(0).setGrantedAuthorities(grantedAuthorities);
			return users.get(0);
		}
		return null;
	}

}
