package com.wdh.blog.task;

import com.wdh.blog.service.DeleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author wangdonghao
 */
@Component
@Slf4j
public class DeleteScheduler {

    @Resource
    DeleteService deleteService;

    @Scheduled(cron = "0 30 1 * * ?")
    public void execute() {
        Long start = System.currentTimeMillis();
        log.info("------------------------------------------------");
        log.info("DeleteScheduler execute start time = {}", new Date(start));
        deleteService.deleteMarkedData();
        Long end = System.currentTimeMillis();
        log.info("DeleteScheduler execute end time = {}", new Date(end));
        log.info("DeleteScheduler execute cost = {} millisecond", end - start);
        log.info("------------------------------------------------");

    }

}
