package cn.ffcs.secimpl;

import cn.ffcs.model.User;
import cn.ffcs.restsec.AuthenticationService;
import cn.ffcs.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Implements Spring Security {@link UserDetailsService} that is injected into authentication provider in configuration XML.
 * It interacts with domain, loads user details and wraps it into {@link UserContext} which implements Spring Security {@link UserDetails}.
 */
public class MyUserDetailsService implements UserDetailsService {

	protected Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;

	/**
	 * This will be called from
	 * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider#retrieveUser(java.lang.String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)}
	 * when {@link AuthenticationService#authenticate(java.lang.String, java.lang.String)} calls
	 * {@link AuthenticationManager#authenticate(org.springframework.security.core.Authentication)}. Easy.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		user.setName(username);
		System.out.println(" *** MyUseDetailService.loadUserByUsername");
		user= userService.findOne(user);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " not found");
		}
		return new UserContext(user);
	}
}
