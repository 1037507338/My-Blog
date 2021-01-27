package com.wdh.blog.service.impl;

import com.wdh.blog.dao.BlogCategoryMapper;
import com.wdh.blog.dao.BlogCommentMapper;
import com.wdh.blog.dao.BlogMapper;
import com.wdh.blog.dao.BlogTagMapper;
import com.wdh.blog.service.DeleteService;
import com.wdh.blog.util.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;


/**
 * @author wangdonghao
 */
@Service
@Slf4j
public class DeleteServiceImpl implements DeleteService {

    @Resource
    BlogCategoryMapper blogCategoryMapper;
    @Resource
    BlogMapper blogMapper;
    @Resource
    BlogTagMapper blogTagMapper;
    @Resource
    BlogCommentMapper blogCommentMapper;

    @Override
    public void deleteMarkedData() {

        LocalDate now = LocalDate.now();
        Date deleteDateTime = DateTimeUtil.localDate2Date(now.minusDays(7));
        Integer blogCategoryResult = blogCategoryMapper.deleteMarkedData(deleteDateTime);
        Integer blogResult = blogMapper.deleteMarkedData(deleteDateTime);
        Integer blogTagResult = blogTagMapper.deleteMarkedData(deleteDateTime);
        Integer blogCommentResult = blogCommentMapper.deleteMarkedData(deleteDateTime);
        log.info("DeleteScheduler execute blogCategoryResult = {}, blogResult = {}, blogTagResult = {}, blogCommentResult = {}", blogCategoryResult, blogResult, blogTagResult, blogCommentResult);

    }
}
