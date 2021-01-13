package com.wdh.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wangdonghao
 */
@Data
public class BlogConfig {

    private String configName;

    private String configValue;

    private Date createTime;

    private Date updateTime;

}