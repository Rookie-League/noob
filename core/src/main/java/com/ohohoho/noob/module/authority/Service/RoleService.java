package com.ohohoho.noob.module.authority.service;

import com.ohohoho.noob.module.authority.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author majunjie
 * @description
 * @date 2017/3/24 14:22
 */
@Service
@Transactional(readOnly = true)
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    public List<String> getPermissionsNameByRoleId(Integer roleId){
        return roleMapper.getPermissionsNameByRoleId(roleId);
    }



}
