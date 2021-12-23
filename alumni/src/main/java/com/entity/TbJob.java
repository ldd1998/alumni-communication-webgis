package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.catalina.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbJob implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 职位id
     */
    @TableId(value = "job_id", type = IdType.AUTO)
    private Integer jobId;

    /**
     * 公司名称
     */
    private String jobCompany;

    /**
     * 职位名称
     */
    private String jobName;

    /**
     * 职位介绍
     */
    private String jobDesc;

    /**
     * 校友id
     */
    private String userid;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime jobTime;

    /**
     * 招聘人数
     */
    private String perCount;

    /**
     * 工作地址
     */
    private String jobAddress;

    /**
     * 投递地址
     */
    private String jobEmail;

    /**
     * 审核状态：0未审核，1已通过，2未通过
     */
    private Integer checkStatus;

    /**
     * 审核意见
     */
    private String checkOpinion;

    /**
     * 校友实体
     */
    private UserInfo tbStu;


}
