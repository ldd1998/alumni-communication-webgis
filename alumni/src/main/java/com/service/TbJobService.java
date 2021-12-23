package com.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.entity.TbJob;
import com.mapper.TbJobMapper;
import com.util.QueryObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgy
 * @since 2020-02-17
 */
@Service
public class TbJobService {

    @Autowired
    private TbJobMapper jobMapper;

    public IPage<TbJob> getAllJob(long page, long limit, QueryWrapper<QueryObj> queryWrapper) {

        return jobMapper.getAllJob(new Page<>(page,limit),queryWrapper);
    }

    public TbJob getJobById(Integer jobId) {
        return jobMapper.getJobById(jobId);
    }
}
