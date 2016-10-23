package org.reichel.schedule.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.reichel.schedule.business.UserBusiness;
import org.reichel.schedule.domain.Role;
import org.reichel.schedule.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserBusiness userBusiness;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userBusiness.findByLogin(username);
		if(user == null){
			throw new UsernameNotFoundException("Bad credentials");
		}
		return new CustomUserDetails(user);
	}

	private final static class CustomUserDetails implements UserDetails {

        private static final long serialVersionUID = 1L;

        private User user;
        
        private CustomUserDetails(User user) {
        	this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        	for (Role role : user.getRoles()) {
    			authorities.add(new SimpleGrantedAuthority(role.getRole()));
    		}        	
        	return authorities;
        }

        @Override
        public String getUsername() {
            return this.user.getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return this.user.getEnabled();
        }
        
		@Override
		public String getPassword() {
			return this.user.getPassword();
		}
    }
}
