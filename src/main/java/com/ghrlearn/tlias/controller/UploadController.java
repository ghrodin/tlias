package com.ghrlearn.tlias.controller;

import com.ghrlearn.tlias.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile
            image) throws IOException {
        log.info("文件上传：{},{},{}", username, age, image);
//获取原始文件名
        String originalFilename = image.getOriginalFilename();
//将文件存储在服务器的磁盘目录
        image.transferTo(new File("E:/images/" + originalFilename));

        return Result.success();
    }
}
