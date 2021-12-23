package com.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.TbDon;
import com.util.QueryObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgy
 * @since 2020-03-19
 */
public interface TbDonMapper{

    /**
     * 分页查询
     * @param page
     * @param wrapper
     * @return
     */
    IPage<TbDon> getAllDon(Page<TbDon> page, @Param("we") QueryWrapper<QueryObj> wrapper);

    TbDon getDonById(Integer donId);

    boolean save(TbDon tbDon);

    List<TbDon> queryDonateListByLimit(int page, int limit);
}
