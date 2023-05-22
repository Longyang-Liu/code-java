package com.liu.base.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUpload {
    public static String uploadFile(MultipartFile upload, String path) throws IOException {
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //如果这个文件夹不存在的话,就创建这个文件
            file.mkdirs();
        }
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置成唯一值 uuid 以防止文件名相同覆盖
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //新文件名
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));
        return filename;
    }
}
