package com.wdh.blog.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author wangdonghao
 */
public class DateTimeUtil {

    //localDate转date
    public static Date localDate2Date(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

}
