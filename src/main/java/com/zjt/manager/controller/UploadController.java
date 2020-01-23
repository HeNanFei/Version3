package com.zjt.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    @RequestMapping(value = "/uploadDocs",produces="application/json;charset=utf-8")
    @ResponseBody
    public Map<String,Object> uploadDocs(MultipartFile file,String grade,String project) {
        System.out.println(grade+project);
        Map<String, Object> uploadData = new HashMap<String, Object>();
        String uploadDocsPath = "C:\\Users\\Administrator\\Desktop\\"+grade+"\\"+project+"\\";
        String fileName = file.getOriginalFilename();
        File dir = new File(uploadDocsPath, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            file.transferTo(dir);
            uploadData.put("code", 0);
            uploadData.put("msg", "上传成功");
            uploadData.put("data", "");
        } catch (IOException e) {
            uploadData.put("code", -1);
            uploadData.put("msg", "上传失败");
            uploadData.put("data", "");
        }
        return uploadData;

    }
}
