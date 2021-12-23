package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
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
public class TbDon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 捐赠id
     */
    @TableId(value = "don_id", type = IdType.AUTO)
    private Integer donId;

    /**
     * 捐赠name
     */
    private String donName;

    /**
     * 捐赠描述
     */
    private String donDesc;

    /**
     * 捐赠人id
     */
    private String userid;

    /**
     * 捐赠人
     */
    private UserInfo userInfo;

    /**
     * 审核状态
     */
    private int donStatus;

    /**
     * 审核意见
     */
    private String donOpinion;

    /**
     * 捐赠时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime donTime;


}
