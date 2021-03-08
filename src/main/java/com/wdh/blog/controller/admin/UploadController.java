package com.wdh.blog.controller.admin;

import com.wdh.blog.config.Constants;
import com.wdh.blog.util.FileUtil;
import com.wdh.blog.util.MyBlogUtils;
import com.wdh.blog.util.Result;
import com.wdh.blog.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.wdh.blog.config.Constants.FILE_TEMP_DIC;
import static com.wdh.blog.config.Constants.LINUX_FILE_TEMP_DIC;

/**
 * @author wangdonghao
 */
@Controller
@RequestMapping("/admin")
public class UploadController {

    @PostMapping({"/upload/file"})
    @ResponseBody
    public Result upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws URISyntaxException, IOException {
        String fileName = file.getOriginalFilename();
        //生成文件名称通用方法
        File destFile = FileUtil.createFile(FILE_TEMP_DIC, fileName);
        String fileUrl = MyBlogUtils.getHost(new URI(request.getRequestURL() + "")) + LINUX_FILE_TEMP_DIC + destFile.getName();
        try {
            file.transferTo(destFile);
            request.setCharacterEncoding("utf-8");
            Result resultSuccess = ResultGenerator.genSuccessResult();
            resultSuccess.setData(fileUrl);
            return resultSuccess;
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("文件上传失败");
        }
    }

}
