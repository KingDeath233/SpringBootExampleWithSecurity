package com.yc.config;

import com.yc.dao.UsersDAO;
import com.yc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserInfoService implements UserDetailsService {

    private final UsersDAO usersDAO;

    @Autowired
    public UserInfoService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public UserDetails loadUserByUsername(String username){
        Users activeUser = usersDAO.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUser.getRole());
        UserDetails userDetails = new User(activeUser.getUsername(),activeUser.getPassword(),
                Arrays.asList(authority));
        return userDetails;
    }
}
