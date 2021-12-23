package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具类
 */
public class DateUtil {


    public static String getCreateDate(String createTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(createTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String now = new SimpleDateFormat("yyyy年MM月dd日 HH点").format(date);

        return now;
    }

    public static String getUpdateDate(String updateTime){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").parse(updateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String now = new SimpleDateFormat("yyyy年MM月dd日 HH点").format(date);

        return now;
    }

}
