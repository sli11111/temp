package com.scfsoft.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;

@RequestMapping("/autn")
@RestController
public class AutnController {
    @GetMapping("/loadFile")
    public void loadFile(HttpServletResponse response) throws IOException {
        File file = FileUtil.file("E:\\test\\test.pdf");
        FileUtil.writeToStream(file, response.getOutputStream());
        response.setContentType("application/pdf");

    }
}
