package top.dragon.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.dragon.service.FileService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@Api(tags = "文件")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "上传文件")
    public String uploadFile(
            @ApiParam(value = "文件")MultipartFile file){
        return  fileService.upload(file);
    }
    @PostMapping("/uploads")
    @ApiOperation(value = "上传多个文件")
    public List<String> uploadFiles(
            @ApiParam(value = "文件数组") MultipartFile[] file){
        return  fileService.uploads(Arrays.asList(file));
    }
}
