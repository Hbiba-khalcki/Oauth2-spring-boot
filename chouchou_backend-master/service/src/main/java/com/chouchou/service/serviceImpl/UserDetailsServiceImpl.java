package com.chouchou.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chouchou.model.UserManager;
import com.chouchou.service.UserService;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserManager usermanger=userService.findByLogin(username);
		 System.out.println("nombre des roles :"+ usermanger.getRoles().size());
		if (usermanger == null) throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for(int i=0;i<usermanger.getRoles().size();i++ )
		{
			authorities.add(new SimpleGrantedAuthority(usermanger.getRoles().get(i).getNomRole()));
		}
/*
		List<GrantedAuthority> authorities = new ArrayList<>();
		usermanger.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getNomRole()));
          
        });
				*/
		
		return (UserDetails) new User( usermanger.getLogin(),usermanger.getPassword(),authorities);
		
	
	}

}
