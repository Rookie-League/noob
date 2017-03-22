package com.ohohoho.noob.module.constant.mapper;

import com.ohohoho.noob.module.constant.domain.ConstantChild;
import com.ohohoho.noob.module.constant.domain.ConstantParentId;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yaojiamin
 * @description TODO
 * @createTime 2016-6-8 上午10:08:07
 */
public interface FindConstantByParentIdMapper extends Mapper<ConstantChild>{
    List<ConstantChild> select(ConstantParentId findConstantByParentId);
}
