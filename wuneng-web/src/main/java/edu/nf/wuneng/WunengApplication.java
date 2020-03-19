package edu.nf.wuneng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YXD
 * @date 2020/3/6
 */
@SpringBootApplication
@MapperScan({"edu.nf.wuneng.user.dao","edu.nf.wuneng.admin.dao"})
public class WunengApplication {
    public static void main(String[] args) {
        SpringApplication.run(WunengApplication.class,args);
    }
}