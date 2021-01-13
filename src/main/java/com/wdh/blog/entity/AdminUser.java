package com.wdh.blog.entity;

import lombok.Data;

/**
 * @author wangdonghao
 */
@Data
public class AdminUser {

    private Integer adminUserId;

    private String loginUserName;

    private String loginPassword;

    private String nickName;

    private Byte locked;

}