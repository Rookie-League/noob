package com.ohohoho.noob.module.authority.Service;

import com.ohohoho.noob.module.authority.domain.Account;
import com.ohohoho.noob.module.authority.domain.Role;
import com.ohohoho.noob.module.authority.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author majunjie
 * @description you know
 * @date 2017/3/24 10:32
 */
@Service
@Transactional(readOnly = true)
public class AccountService {

    private AccountMapper accountMapper;

    public Account findByUsername(String username){
        return accountMapper.findByUsername(username);
    }


    @Transactional( readOnly = false)
    public void insert(Account accout){
        accountMapper.insert(accout);
    }

    public List<Role> getRoleListbyId(Integer id){
        return accountMapper.getRoleListbyId(id);
    }

}
