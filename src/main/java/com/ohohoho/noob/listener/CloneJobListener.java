package com.ohohoho.noob.listener;

import com.earphone.schedule.quartz.BasicSchedulingListener;
import com.ohohoho.noob.module.constant.service.ConstantService;

import javax.annotation.Resource;

/**
 * @author YaoJiamin
 * @description
 * @createDate 2016/12/12
 * @createTime 17:47
 */
public class CloneJobListener extends BasicSchedulingListener {
    @Resource
    private ConstantService constantService;

    @Override
    protected String parsePeriodKey(String periodKey) {
        return constantService.findByKey(periodKey).getValue();
    }
}
