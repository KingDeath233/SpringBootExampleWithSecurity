package com.yc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserInfoService userInfoService;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public SecurityConfig(UserInfoService userInfoService, AuthenticationEntryPoint authenticationEntryPoint){
        this.userInfoService = userInfoService;
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/register").permitAll()
                .antMatchers("/user/forgetpassword").permitAll()
                .antMatchers("/user/userfindallfree").permitAll()
                .antMatchers("/**").authenticated()
                .and().httpBasic().realmName("YCC")
                .authenticationEntryPoint(authenticationEntryPoint);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userInfoService).passwordEncoder(passwordEncoder);
    }

}
