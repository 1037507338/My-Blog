package com.wdh.blog.controller.admin;

import com.wdh.blog.config.Constants;
import com.wdh.blog.task.DeleteScheduler;
import com.wdh.blog.util.Result;
import com.wdh.blog.util.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangdonghao
 */
@RestController
@RequestMapping("/backdoor")
public class BackDoorController {

    @Resource
    DeleteScheduler deleteScheduler;

    @GetMapping("/testDeleteScheduler")
    public Result testDeleteScheduler(String backDoorKey) {
        if (!backDoorKey.equalsIgnoreCase(Constants.BACK_DOOR_KEY)) {
            return ResultGenerator.genFailResult("backDoorKey is error");
        }
        deleteScheduler.execute();
        return ResultGenerator.genSuccessResult(1);
    }

}
