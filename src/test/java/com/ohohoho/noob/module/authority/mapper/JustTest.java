package com.ohohoho.noob.module.authority.mapper;

import com.earphone.utility.utils.JSONUtils;
import com.ohohoho.noob.config.DruidDBConfig;
import com.ohohoho.noob.config.TransactionConfig;
import com.ohohoho.noob.module.authority.Service.AccountService;
import com.ohohoho.noob.module.authority.Service.RoleService;
import com.ohohoho.noob.module.authority.domain.Account;
import com.ohohoho.noob.module.authority.domain.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author majunjie
 * @description
 * @date 2017/3/24 11:14
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration(classes = {TransactionConfig.class, DruidDBConfig.class}, loader = SpringBootContextLoader.class)
public class JustTest  extends AbstractTestNGSpringContextTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(JustTest.class);

    @Resource
    private AccountService accountService;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private RoleMapper roleMapper;

    @Test
    public void testInsert() {

        Account account = new Account();
        account.setUsername("xiaoma");
        account.setPassword("123456");

        accountMapper.insert(account);

        LOGGER.info(JSONUtils.toJSON(account));
    }

    @Test
    public void testGetRoleName() {

        List<Role> roleList = accountMapper.getRoleListbyId(1);

        for (Role role : roleList) {

            LOGGER.info( "boom=====" + JSONUtils.toJSON(roleMapper.getPermissionsNameByRoleId(role.getId())));

        }

    }

}
