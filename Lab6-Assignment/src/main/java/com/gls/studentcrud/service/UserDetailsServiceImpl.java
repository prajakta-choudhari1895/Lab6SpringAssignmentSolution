package com.gls.studentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gls.studentcrud.entity.User;
import com.gls.studentcrud.repository.UserRepository;
import com.gls.studentcrud.security.MyUserDetails;



public class UserDetailsServiceImpl implements UserDetailsService {

	   @Autowired
	    private UserRepository userRepository;
	     
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	        User user = userRepository.getUserByUsername(username);
	        
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	        System.out.println("username:"+user.getUsername()+"password"+user.getPassword());
	        return new MyUserDetails(user);
	    }

}
