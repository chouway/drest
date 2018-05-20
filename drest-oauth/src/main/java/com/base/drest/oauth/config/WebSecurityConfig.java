package com.base.drest.oauth.config;

import com.base.drest.oauth.service.DrestUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * WebSecurityConfig
 * @author zhouyw
 * @date 2018.05.20
 */
@Order(10)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DrestUserDetailsService drestUserDetailsService;

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
            .loginPage("/login")
            .failureForwardUrl("/login?error")
            .successForwardUrl("/oauth/confirm_access")

             .permitAll()
            .and().authorizeRequests().antMatchers("/health", "/css/**").anonymous()
            .and().authorizeRequests().anyRequest().authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(drestUserDetailsService);
      //auth.parentAuthenticationManager();//可设置父的认证管理。
    }

}
