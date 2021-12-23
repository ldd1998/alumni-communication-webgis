package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbDepart implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 院系id
     */
    @TableId(value = "depart_id", type = IdType.AUTO)
    private Integer departId;

    /**
     * 院系名字
     */
    private String departName;


}
