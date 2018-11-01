package com.kkl.demo.oauth2.server.service;

import com.kkl.demo.oauth2.server.entity.CustomUserDetails;
import com.kkl.demo.oauth2.server.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailService")
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /*模拟数据库操作*/
        User user = new User();
        user.setUserId(123L);
        user.setUsername("admin");
        user.setPassword("admin");
        return new CustomUserDetails(user);
    }
}
