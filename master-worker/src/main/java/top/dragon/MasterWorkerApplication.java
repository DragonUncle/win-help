package top.dragon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("top.dragon.mapper")
public class MasterWorkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterWorkerApplication.class, args);
    }

}
