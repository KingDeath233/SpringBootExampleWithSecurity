package com.yc.controller;

import com.common.Method.UniversalMethod;
import com.yc.entity.Users;
import com.yc.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping("/usersfindall")
    public List<Users> usersFindAll(){
        return usersService.usersFindAll();
    }

    @Secured({"ROLE_USER"})
    @GetMapping("/usersfindalluser")
    public List<Users> usersFindAllUser(){
        return usersService.usersFindAllUser();
    }

    @GetMapping("/usersfindallfree")
    public List<Users> usersFindAllFree(){
        return usersService.usersFindAllUser();
    }

    @GetMapping("/login")
    public ResponseEntity login(){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody("", "Success"), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Users obj){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody(usersService.register(obj), "Success"), HttpStatus.OK);
    }

    @PostMapping("/userupdateuserinfo")
    public ResponseEntity userUpdateUserInfo(@RequestBody Users obj){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody(usersService.userUpdateUserInfo(obj), "Success"), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/adminupdateuserinfo")
    public ResponseEntity adminUpdateUserInfo(@RequestBody Users obj){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody(usersService.adminUpdateUserInfo(obj), "Success"), HttpStatus.OK);
    }

    @PutMapping("/changepassword")
    public ResponseEntity changePassword(HttpServletRequest request){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody(usersService.changePassword(request), "Success"), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/resetpassword")
    public ResponseEntity resetPassword(HttpServletRequest request){
        return new ResponseEntity<>(UniversalMethod.generateResponseEntityBody(usersService.resetPassword(request), "Success"), HttpStatus.OK);
    }
}
