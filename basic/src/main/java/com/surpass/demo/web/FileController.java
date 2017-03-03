package com.surpass.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Map;

/**
 * 文件上传下载
 * <p>
 * Created by surpass.wei@gmail.com on 2017/2/27.
 */
@Controller
public class FileController {

    @Value("${upload.basePath}")
    private String basePath;

    @RequestMapping("/file")
    public String file() {
        return "file";
    }

    @RequestMapping("/files")
    public String files() {
        return "files";
    }

    @RequestMapping("/upload-file")
    @ResponseBody
    public String upload(@RequestParam MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            try {
                File file = new File(basePath + multipartFile.getOriginalFilename());
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                out.write(multipartFile.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败：" + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败：" + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败：文件为空。";
        }
    }

    @RequestMapping("/upload-files")
    @ResponseBody
    public String uploadFiles(@RequestParam MultipartFile[] multipartFiles,
                              Map<String,String> map) {
        if (multipartFiles != null && multipartFiles.length > 0) {
            for (MultipartFile multipartFile : multipartFiles) {
                if (!multipartFile.isEmpty()) {
                    String filename = multipartFile.getOriginalFilename();
                    try {
                        File file = new File(basePath + filename);
                        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
                        out.write(multipartFile.getBytes());
                        out.flush();
                        out.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        map.put(filename, "路径错误");
                    } catch (IOException e) {
                        e.printStackTrace();
                        map.put(filename, "上传失败");
                    }
                }
            }
        }
        return map.toString();
    }
}
