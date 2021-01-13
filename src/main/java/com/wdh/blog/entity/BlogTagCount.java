package com.wdh.blog.entity;

import lombok.Data;

/**
 * @author wangdonghao
 */
@Data
public class BlogTagCount {

    private Integer tagId;

    private String tagName;

    private Integer tagCount;

}
