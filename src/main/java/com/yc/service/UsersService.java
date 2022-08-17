package com.yc.service;

import com.yc.dao.UsersDAO;
import com.yc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public List<Users> usersFindAll(){
        UserDetails userinfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userinfo.getUsername());
        System.out.println(userinfo.getAuthorities());
        return usersDAO.findAll();
    }

    public List<Users> usersFindAllUser(){
        return usersDAO.findAll();
    }
}
