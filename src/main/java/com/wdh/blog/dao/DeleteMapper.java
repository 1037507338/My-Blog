package com.wdh.blog.dao;

import java.util.Date;

/**
 * @author wangdonghao
 */
public interface DeleteMapper {

    int deleteMarkedData(Date createTime);

}
