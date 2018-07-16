package com.vlearncom.service;

import com.vlearncom.dao.SysRoleRepository;
import com.vlearncom.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {
    @Autowired
    SysRoleRepository sysRoleRepository;

    public List<SysRole> findAll() {
        return sysRoleRepository.findAll();
    }
}
