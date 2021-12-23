package com.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.entity.UserInfo;
import com.util.QueryObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lgy
 * @since 2019-12-29
 */
public interface TbStuMapper {


    /**
     * 分页查询所有的校友信息
     * @param page
     * @param wrapper
     * @return
     */
    IPage<UserInfo> selectStuPage(Page page, @Param("we") Wrapper<QueryObj> wrapper);

    /**
     * 分页查询校友会下的校友信息
     * @param page
     * @param assId
     * @return
     */
    IPage<UserInfo> getAssStuById(Page page, Integer assId);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    UserInfo getByUserName(String username);

    /**
     * 查询参与活动的校友
     * @param page
     * @param acId
     * @return
     */
    IPage<UserInfo> selectActJoinById(Page page, Integer acId);


    //保存毕业生用户
    boolean save(UserInfo tbStu);

    boolean removeByIds(List<String> userIds);
}
