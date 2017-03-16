package com.ohohoho.noob.module.constant.mapper;

import com.ohohoho.noob.module.constant.domain.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by thythm on 2017/3/16.
 */
public interface RoleMapper extends Mapper<Role>{


    List<String> getPermissionsNameById(Integer id);

}
