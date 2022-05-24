package top.dragon.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtils {

    /**
     * 删除文件
     *
     * @param filePath 文件路径
     * @return 是否删除成功
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }


    /**
     * 写到文件
     * @param fileByte  文件内容
     * @param fileName  文件名称
     * @param filePath  文件路径
     * @return  写出是否成功
     * @throws IOException  异常
     */
    public static Boolean writeFile(byte[] fileByte, String fileName, String filePath) throws IOException {
        File file = new File(filePath );
        if (!file.isDirectory()) if (!file.mkdirs()) return false;
        File newFile = new File(filePath +"/"+  fileName);
        FileCopyUtils.copy(fileByte, newFile);
        return true;
    }

}
