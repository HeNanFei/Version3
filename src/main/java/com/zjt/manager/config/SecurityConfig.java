package com.zjt.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();

    }

  /*  @Bean
    public UserDetailsService getUs() {

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(User.withUsername("xiaoming").password(new BCryptPasswordEncoder().encode("123")).roles("manager").authorities("p1").build());
        userDetailsManager.createUser(User.withUsername("xiaohong").password(new BCryptPasswordEncoder().encode("123")).roles("waitress").authorities("p2").build());

        return userDetailsManager;
    }
*/
    @Configuration
    @Order(1)
    public static class LoginConfig extends WebSecurityConfigurerAdapter {
       /* @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.headers().frameOptions().disable();
            http.authorizeRequests().antMatchers("/user/**").authenticated().antMatchers("/user/**").hasAuthority("root")
                   .and().formLogin().loginPage("/login2").loginProcessingUrl("/login/test")
                    .successForwardUrl("/success").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

            http.authorizeRequests().antMatchers("/test/**").authenticated().
                    antMatchers("/test/**").hasAuthority("1");

            http.authorizeRequests().antMatchers("/teacher/**").authenticated().
                    antMatchers("/teacher/**").hasAuthority("root");

        }*/


       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable();
           http.headers().frameOptions().disable();
           http.authorizeRequests().antMatchers("/user/add").authenticated().antMatchers("/user/add").hasAuthority("7")
                   .and().formLogin().loginPage("/login2").loginProcessingUrl("/login/test")
                   .successForwardUrl("/success").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

          /* http.authorizeRequests().antMatchers("/test/**").authenticated().
                   antMatchers("/test/**").hasAuthority("1");*/

           http.authorizeRequests().antMatchers("/teacher/delete").authenticated().
                   antMatchers("/teacher/delete").hasAuthority("7");

           http.authorizeRequests().antMatchers("/teacher/add").authenticated().
                   antMatchers("/teacher/add").hasAuthority("7");



           http.authorizeRequests().antMatchers("/teacher/realUpdate").authenticated().
                   antMatchers("/teacher/realUpdate").hasAuthority("7");


           http.authorizeRequests().antMatchers("/student/delete").authenticated().
                   antMatchers("/student/delete").hasAuthority("7");

           http.authorizeRequests().antMatchers("/user/delete").authenticated().
                   antMatchers("/user/delete").hasAuthority("7");

           http.authorizeRequests().antMatchers("/user/realUpdate").authenticated().
                   antMatchers("/user/realUpdatee").hasAuthority("7");

       }
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.csrf().disable();
        // .antMatchers("/author/**").hasAuthority("p2").antMatchers("/pri/**").authenticated()
        http.authorizeRequests().antMatchers("/user/**").authenticated().antMatchers("/user/**").hasAuthority("root")
                .anyRequest().permitAll();*//*.and().formLogin().loginPage("/login2").loginProcessingUrl("/login/test")
                .successForwardUrl("/success").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);*//*
        http.authorizeRequests().anyRequest().authenticated().anyRequest().hasAnyAuthority("1","2","3","root").anyRequest().permitAll()
                .and().formLogin().loginPage("/login2").loginProcessingUrl("/login/test").successForwardUrl("/success");

    }
*/

}
