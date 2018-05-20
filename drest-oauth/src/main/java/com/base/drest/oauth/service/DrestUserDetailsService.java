package com.base.drest.oauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * DrestUserDetailsService
 * @author zhouyw
 * @date 2018.05.20
 */
@Service
public class DrestUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(DrestUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("-->username={}", username);

        if ("admin".equalsIgnoreCase(username)) {
            User user = mockUser();
            return user;
        }
        throw new UsernameNotFoundException("用户不存在");
    }
    private User mockUser() {

        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("admin"));//用户所拥有的角色信息
        User user = new User("admin","123456",authorities);
        return user;

    }

}
