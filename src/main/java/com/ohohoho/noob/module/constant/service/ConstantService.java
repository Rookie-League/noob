package com.ohohoho.noob.module.constant.service;

import com.ohohoho.noob.module.constant.domain.Constant;
import com.ohohoho.noob.module.constant.mapper.ConstantMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(readOnly = true)
public class ConstantService {
    @Resource
    private ConstantMapper constantMapper;

    public Constant findByKey(String key) {
        return constantMapper.findByKey(key);
    }

    public Constant findNoCacheByKey(String key) {
        return constantMapper.findNoCacheByKey(key);
    }
}
