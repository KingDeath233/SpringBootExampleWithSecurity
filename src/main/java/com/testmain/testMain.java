package com.testmain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testMain {
    public static void main(String args[]){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("yechao941208"));
    }
}
