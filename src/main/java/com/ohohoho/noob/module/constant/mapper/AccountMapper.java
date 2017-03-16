package com.ohohoho.noob.module.constant.mapper;

import com.ohohoho.noob.module.constant.domain.Account;
import com.ohohoho.noob.module.constant.domain.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

/**
 * Created by thythm on 2017/3/16.
 */
public interface AccountMapper extends Mapper<Account>{

   Account findByUsername(String username);
   Set<String> getRolesNamebyId(Integer id);
   List<Role> getRoleListbyId(Integer id);
   List<Account> getList();

}
