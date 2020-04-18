package com.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harjoitustyo.domain.UserCred;
import com.harjoitustyo.domain.UserCredRepository;


	/**
	 * This class is used by spring security to authenticate and authorize user
	 **/
	@Service
	public class UserDetailServiceImpl implements UserDetailsService  {
		private final UserCredRepository urepository;

		@Autowired
		public UserDetailServiceImpl(UserCredRepository userRepository) {
			this.urepository = userRepository;
		}

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	    {   
	    	UserCred curruser = urepository.findByUsername(username);
	        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
	        		AuthorityUtils.createAuthorityList(curruser.getRole()));
	        return user;
	    }   
	} 

