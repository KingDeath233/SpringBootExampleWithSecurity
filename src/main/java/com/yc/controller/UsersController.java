package com.yc.controller;

import com.yc.entity.Users;
import com.yc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }



    @Secured({"ROLE_ADMIN"})
    @GetMapping("/UsersFindAll")
    public List<Users> usersFindAll(){
        return usersService.usersFindAll();
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/UsersFindAllUser")
    public List<Users> usersFindAllUser(){
        return usersService.usersFindAllUser();
    }
}
