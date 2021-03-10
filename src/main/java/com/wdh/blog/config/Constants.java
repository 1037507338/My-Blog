package com.wdh.blog.config;

/**
 * @author wangdonghao
 */
public class Constants {

    public static String FILE_UPLOAD_DIC;

    public static String FILE_TEMP_DIC;

    public static Boolean LINUX_SERVER = true;

    public static String HOST_NAME;

    public static String LINUX_FILE_UPLOAD_DIC = "/web/upload/";

    public static String WIN_FILE_UPLOAD_DIC = "D:/web/upload/";

    public static String LINUX_FILE_TEMP_DIC = "/web/temp/";

    public final static String WIN_FILE_TEMP_DIC = "D:/web/temp/";

    static {
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            LINUX_SERVER = false;
            FILE_UPLOAD_DIC = WIN_FILE_UPLOAD_DIC;
            FILE_TEMP_DIC = WIN_FILE_TEMP_DIC;
            HOST_NAME = "localhost";
        } else {
            FILE_UPLOAD_DIC = LINUX_FILE_UPLOAD_DIC;
            FILE_TEMP_DIC = LINUX_FILE_TEMP_DIC;
            HOST_NAME = "http://wangdonghao.top";
        }
    }

    public final static String BACK_DOOR_KEY = "54188wang";

    public static final String websiteName = "personal blog";
    public static final String websiteDescription = "personal blog是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码.个人博客搭建";
    public static final String websiteLogo = "/admin/dist/img/logo.png";
    public static final String websiteIcon = "/admin/dist/img/logo.png";
    public static final String websiteSlogan = "6666666666666666666";

    public static final String yourAvatar = "/admin/dist/img/wdh.png";
    public static final String yourEmail = "2449207463@qq.com";
    public static final String yourName = "十三";

    public static final String footerAbout = "your personal blog. have fun.";
    public static final String footerICP = "浙ICP备 xxxxxx-x号";
    public static final String footerCopyRight = "@2018 十三";
    public static final String footerPoweredBy = "personal blog";
    public static final String footerPoweredByURL = "##";
}
