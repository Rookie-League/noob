package com.ohohoho.noob.module.constant.service;

import com.github.pagehelper.PageHelper;
import com.ohohoho.noob.module.constant.domain.Constant;
import com.ohohoho.noob.module.constant.mapper.ConstantMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConstantService {
    @Resource
    private ConstantMapper constantMapper;

    public Constant findByKey(String key) {
        Constant constant = new Constant();
        constant.setKey(key);
        return constantMapper.selectOne(constant);
    }

    public List<Constant> findChildrenByParentId(Long parentId) {
        Constant constant = new Constant();
        constant.setParentId(parentId);
        return PageHelper.startPage(1, 1).doSelectPage(() -> constantMapper.select(constant));
    }
}
