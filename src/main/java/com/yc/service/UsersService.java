package com.yc.service;

import com.alibaba.fastjson.JSONObject;
import com.common.Method.UniversalMethod;
import com.common.exceptionClass.UserException;
import com.yc.dao.UsersDAO;
import com.yc.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public String register(Users obj){
        if(usersDAO.existsById(obj.getUsername())){
            throw new UserException("User name already exist!");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
        obj.setRole("ROLE_USER");
        if(usersDAO.save(obj)!=null){
            return "Success";
        }else{
            return "Fail";
        }
    }

    public String userUpdateUserInfo(Users obj){
        UserDetails userinfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUserWithPassword = usersDAO.findByUsername(userinfo.getUsername());
        currentUserWithPassword.setFullname(obj.getFullname());
        currentUserWithPassword.setEmail(obj.getEmail());
        currentUserWithPassword.setPhone(obj.getPhone());
        if(usersDAO.save(currentUserWithPassword) != null){
            return "Success";
        }else{
            return "Fail";
        }
    }

    public String adminUpdateUserInfo(Users obj){
        Users specifiedUserWithPassword = usersDAO.findByUsername(obj.getUsername());
        specifiedUserWithPassword.setFullname(obj.getFullname());
        specifiedUserWithPassword.setEmail(obj.getEmail());
        specifiedUserWithPassword.setPhone(obj.getPhone());
        specifiedUserWithPassword.setUsertype(obj.getUsertype());
        specifiedUserWithPassword.setRole(obj.getRole());
        if(usersDAO.save(specifiedUserWithPassword) != null){
            return "Success";
        }else{
            return "Fail";
        }
    }

    public String changePassword(HttpServletRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JSONObject jsonParam = UniversalMethod.getJSONParam(request);
        UserDetails userinfo = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users currentUserWithPassword = usersDAO.findByUsername(userinfo.getUsername());
        if(!passwordEncoder.matches(jsonParam.get("oldpassword").toString(), currentUserWithPassword.getPassword())){
            throw new UserException("Password is not correct, please try again!");
        }else{
            currentUserWithPassword.setPassword(passwordEncoder.encode(jsonParam.get("newpassword").toString()));
        }
        if(usersDAO.save(currentUserWithPassword)!=null){
            return "Success";
        }else{
            return "Fail";
        }
    }

    public String resetPassword(HttpServletRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        JSONObject jsonParam = UniversalMethod.getJSONParam(request);
        Users specifiedUser = usersDAO.findByUsername(jsonParam.get("username").toString());
        if(specifiedUser == null){
            throw new UserException("User name does not exist!");
        }else{
            specifiedUser.setPassword(passwordEncoder.encode(jsonParam.get("password").toString()));
        }
        if(usersDAO.save(specifiedUser)!=null){
            return "Success";
        }else{
            return "Fail";
        }
    }
}
