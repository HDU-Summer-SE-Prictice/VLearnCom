package com.vlearncom.service;

import com.vlearncom.dao.SysUserRepository;
import com.vlearncom.domain.SysRole;
import com.vlearncom.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;

//    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();    // TODO: 改成更优雅的方式

    @Override
    public UserDetails loadUserByUsername(String username) {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }

    public SysUser save(SysUser sysUser) {
        String username = sysUser.getUsername();
        if (sysUserRepository.findByUsername(username) != null) // 已存在
            return null;
        sysUser.setPassword(passwordEncoder().encode(sysUser.getPassword()));
        sysUser.setLevel(0);
        return sysUserRepository.save(sysUser);
    }

    public SysUser findByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
