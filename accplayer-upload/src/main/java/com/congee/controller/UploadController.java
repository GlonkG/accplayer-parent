package com.congee.controller;

import com.congee.utils.AliyunOSSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/16
 * @time: 9:59
 */
@Controller
public class UploadController {
    Logger logger = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;
    @RequestMapping("/index")
    public String index(){
        return "upload";
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String uploadBlog(MultipartFile file){
        logger.info("============>文件上传");
        String uploadUrl="";
        try {
            if(null != file){
                String filename = file.getOriginalFilename();
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);                    				os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    //上传到OSS
                    uploadUrl = aliyunOSSUtil.upload(newFile);
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return uploadUrl;
    }
}
