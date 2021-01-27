package com.wdh.blog.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangdonghao
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;
}
