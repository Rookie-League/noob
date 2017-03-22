package com.ohohoho.noob.module.constant.service;

import com.ohohoho.noob.module.constant.domain.ConstantParentId;
import com.ohohoho.noob.module.constant.domain.FindConstantByKey;
import com.ohohoho.noob.module.constant.domain.ConstantChild;
import com.ohohoho.noob.module.constant.domain.InsertNewConstant;
import com.ohohoho.noob.module.constant.mapper.FindConstantByKeyMapper;
import com.ohohoho.noob.module.constant.mapper.FindConstantByParentIdMapper;
import com.ohohoho.noob.module.constant.mapper.InsertNewConstantMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ConstantService {
    @Resource
    private InsertNewConstantMapper insertNewConstantMapper;
    @Resource
    private FindConstantByKeyMapper findConstantByKeyMapper;
    @Resource
    private FindConstantByParentIdMapper findConstantByParentIdMapper;

    @Transactional
    public int insert(InsertNewConstant constant) {
        return insertNewConstantMapper.insertSelective(constant);
    }

    public FindConstantByKey findByKey(String key) {
        return findConstantByKeyMapper.selectOne(new FindConstantByKey(key));
    }

    public List<ConstantChild> findChildrenByParentId(Long parentId) {
        return findConstantByParentIdMapper.select(new ConstantParentId(parentId));
    }
}
