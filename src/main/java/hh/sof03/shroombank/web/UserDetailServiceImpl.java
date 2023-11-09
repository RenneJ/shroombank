package hh.sof03.shroombank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.sof03.shroombank.domain.User;
import hh.sof03.shroombank.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Autowired
	public UserDetailServiceImpl(UserRepository userRepo) {
		this.repository = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username);
		if(curruser == null) {
			throw new UsernameNotFoundException("_"); // parameter required for function but not necessary for this application; using default message "Bad credentials"
		}
			UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getHash(), 
					AuthorityUtils.createAuthorityList(curruser.getRole()));
			return user;
		
	}

}
