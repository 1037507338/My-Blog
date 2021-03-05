package com.wdh.blog.util;

import com.wdh.blog.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author wangdonghao
 */
@Slf4j
public class FileUtil {

    /**
     * 清空指定文件夹
     * @param path
     * @return
     */
    public static boolean deleteDir(String path) {
        File file = new File(path);
        //判断是否待删除目录是否存在
        if(!file.exists()){
            System.err.println("The dir are not exists!");
            return false;
        }
        //取得当前目录下所有文件和文件夹
        String[] content = file.list();
        for(String name : content != null ? content : new String[0]){
            File temp = new File(path, name);
            //判断是否是目录
            if(temp.isDirectory()){
                //递归调用，删除目录里的内容
                deleteDir(temp.getAbsolutePath());
                temp.delete();//删除空目录
            }else{
                //直接删除文件
                if(!temp.delete()){
                    log.error("Failed to delete " + name);
                }
            }
        }
        return true;
    }

    public static File createFile(String filePath, String fileName) throws IOException {
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        Random r = new Random();
        //创建文件
        File destFile = new File(filePath + System.currentTimeMillis() + r.nextInt(100) + suffixName);
        File fileDirectory = new File(filePath);
        if (!fileDirectory.exists()) {
            if (!fileDirectory.mkdir()) {
                throw new IOException("文件夹创建失败,路径为：" + fileDirectory);
            }
        }
        return destFile;
    }

}
