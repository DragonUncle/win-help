package top.dragon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@MapperScan("top.dragon.mapper")
public class FileManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileManagementApplication.class, args);
    }

}
