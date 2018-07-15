package com.vlearncom.dao;

import com.vlearncom.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    SysUser findByUsername(String username);
}
