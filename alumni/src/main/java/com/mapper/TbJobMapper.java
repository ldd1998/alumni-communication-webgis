package com.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.TbJob;

import com.util.QueryObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgy
 * @since 2020-02-17
 */
public interface TbJobMapper {

    IPage<TbJob> getAllJob(Page page, @Param("we") QueryWrapper<QueryObj> queryWrapper);

    TbJob getJobById(Integer jobId);

    List<TbJob> queryJobListByLimit(int page, int limit);
}
