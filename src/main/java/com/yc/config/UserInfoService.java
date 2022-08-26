package com.yc.config;

import com.yc.dao.UsersDAO;
import com.yc.entity.Users;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService implements UserDetailsService {

    private final UsersDAO usersDAO;

    @Autowired
    public UserInfoService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) {
        Users activeUser = usersDAO.findByUsername(username);
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        String[] authStrings = activeUser.getRole().split(", ");
        for(String authString : authStrings) {
            authorities.add(new SimpleGrantedAuthority(authString));
        }
        UserDetails userDetails = new User(activeUser.getUsername(),activeUser.getPassword(),
                authorities);
        return userDetails;
    }
}
