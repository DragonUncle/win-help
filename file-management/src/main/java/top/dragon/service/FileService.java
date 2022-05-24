package top.dragon.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {


    String upload(MultipartFile file);

    List<String> uploads(List<MultipartFile> asList);

    //todo:压缩文件
    String zip(List<String> paths);

}
