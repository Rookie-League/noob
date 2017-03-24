package com.ohohoho.noob.module.authority.mapper;

import com.ohohoho.noob.module.authority.domain.Account;
import com.ohohoho.noob.module.authority.domain.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

/**
 * Created by thythm on 2017/3/16.
 */
public interface AccountMapper {

   Account findByUsername(String username);

   void insert(Account accout);

   List<Role> getRoleListbyId(Integer id);

}
