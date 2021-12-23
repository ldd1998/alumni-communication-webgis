package com.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.entity.UserInfo;
import com.mapper.TbStuMapper;

import com.util.QueryObj;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgy
 * @since 2019-12-29
 */
@Service
public class TbStuService {

    @Autowired
    TbStuMapper stuMapper;

    /**
     * 分页查询
     * @param page 第几页
     * @param limit 获取几条数据
     * @return
     */

    public IPage<UserInfo> getAllStu(long page, long limit, Wrapper<QueryObj> wrapper){
        IPage<UserInfo> stuPage = stuMapper.selectStuPage(new Page<>(page,limit),wrapper);
        return stuPage;
    }


    public UserInfo getByUserName(@Param("username") String username) {
        UserInfo stu=stuMapper.getByUserName(username);
        return stu;
    }


    public IPage<UserInfo> getActJoinById(Page<UserInfo> page, Integer acId) {
        IPage<UserInfo> stuPage = stuMapper.selectActJoinById(page,acId);
        return stuPage;
    }


    public boolean save(UserInfo tbStu) {
        return stuMapper.save(tbStu);
    }
    //批量删除用户
    public boolean removeByIds(List<String> userIds) {
        return stuMapper.removeByIds(userIds);
    }
}
