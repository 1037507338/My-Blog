package com.wdh.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wangdonghao
 */
@Data
public class BlogTagRelation {

    private Long relationId;

    private Long blogId;

    private Integer tagId;

    private Date createTime;

}