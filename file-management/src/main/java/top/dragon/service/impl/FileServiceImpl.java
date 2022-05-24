package top.dragon.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.dragon.entity.ConfigParamEntity;
import top.dragon.entity.FileConfig;
import top.dragon.entity.SweetConfig;
import top.dragon.service.FileService;
import top.dragon.service.SystemConfig;
import top.dragon.utils.FileUtils;
import top.dragon.utils.RedisUtil;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Resource
    private FileUtils fileUtils;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private SystemConfig systemConfig;

    public String upload(MultipartFile file) {

        FileConfig fileConfig = redisUtil.read(RedisUtil.systemUpload, FileConfig.class);
        if (fileConfig == null) {
            List<SweetConfig> systemConfigConfig = systemConfig.getConfig(
                    ConfigParamEntity.listInfo("FileConfig",
                            Arrays.asList("path","url")));
            fileConfig = FileConfig.getFileConfig(systemConfigConfig);
            redisUtil.write(RedisUtil.systemUpload, fileConfig);
        }
        String postfix;
        if (file != null) {
            String contentType = file.getContentType();
            String filename = file.getOriginalFilename();
            if(StringUtils.isNotBlank(filename)) {
                postfix = filename.substring(filename.lastIndexOf(".") + 1);
            }else if (StringUtils.isBlank(contentType)) {
                String originalFilename = file.getOriginalFilename();
                if (StringUtils.isBlank(originalFilename)) originalFilename = "xxx.find";
                postfix = originalFilename.substring(originalFilename.lastIndexOf("."));
            } else {
                String[] split = contentType.split("/");
                postfix = split[1];
            }
            String fileName = UUID.randomUUID().toString() + "." + postfix;
            String packetName = String.valueOf(System.currentTimeMillis());
            try {
                logger.info("上传文件：{}", fileName);
                if (FileUtils.writeFile(file.getBytes(), fileName, fileConfig.getPath()+packetName))
                    return String.format("%s/file/%s/%s",fileConfig.getUrl(),packetName,fileName);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("上传文件失败：{}", e.getMessage());
            }
        }
        return null;
    }

    public List<String> uploads(List<MultipartFile> files) {
        //return uploadFileUtil.writePicture(files, "");
        ArrayList<String> tempList = new ArrayList<>();
        return tempList;
    }

}
