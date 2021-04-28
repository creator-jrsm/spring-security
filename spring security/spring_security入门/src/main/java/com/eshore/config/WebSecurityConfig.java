package com.eshore.config;

import com.eshore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Autowired
    UserService userService;

    @Autowired
    private DataSource dataSource;

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails user= User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("yDie")
                .password(encoder.encode("a"))
                .roles("USER");


        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());

        //自定义验证类
        auth.authenticationProvider(myAuthenticationProvider);

//        auth.jdbcAuthentication()
//                .passwordEncoder(encoder)
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password ,1 from user where username =?")
//                .authoritiesByUsernameQuery("select username,role from user where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","home").permitAll()
                .antMatchers("/hello")
                .hasAnyAuthority("ROLE_USER")
                //.hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin();
//                .loginPage("/login").permitAll()
//                .usernameParameter("username").passwordParameter("password")
//                .and()
//                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}
