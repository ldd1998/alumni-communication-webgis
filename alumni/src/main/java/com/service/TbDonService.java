package com.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.TbDon;
import com.mapper.TbDonMapper;
import com.util.QueryObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgy
 * @since 2020-03-19
 */
@Service
public class TbDonService {


    @Autowired
    private TbDonMapper tbDonMapper;


    public IPage<TbDon> getAllDon(long page, long limit, QueryWrapper<QueryObj> wrapper) {
        return tbDonMapper.getAllDon(new Page<TbDon>(page,limit),wrapper);
    }


    public TbDon getDonById(Integer donId) {
        return tbDonMapper.getDonById(donId);
    }

    public boolean save(TbDon tbDon) {
        return tbDonMapper.save(tbDon);
    }
}
