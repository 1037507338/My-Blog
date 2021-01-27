package com.wdh.blog.service;

/**
 * @author wangdonghao
 */
public interface DeleteService {

    /**
     * 定时删除被标记数据
     */
    void deleteMarkedData();

}
