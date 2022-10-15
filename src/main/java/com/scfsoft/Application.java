package com.scfsoft;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.scfsoft.doc.anno.EnableApiDocument;
import com.scfsoft.web.anno.EnableTokenDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author enbrau
 */
@EnableApiDocument
@EnableTokenDecoder
@EnableCaching
@EnableScheduling
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
