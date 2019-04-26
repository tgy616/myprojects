package com.tgy.elas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 默认支持2中技术和es交互
 * 1、Jest(默认不生效)
 * 需要导入jest的工具包（ io.searchbox.client.JestClient）
 * 2、SpringData ElasticSearch [Es版本有可能不合适]
 *    版本说明：https://github.com/spring-projects/spring-data-elasticsearch
 *   如果版本不适配 2.4.6
 *          1) 升级SpringBoot版本
 *          2）安装对应版本的ES
 *   1）Client ClusterNodes ；ClusterName
 *   2）ElasticsearchTemplate
 *   3）编写一个ElasticsearchRepository的子接口来操作ES
 *
 *  2种用法：
 */
@SpringBootApplication
public class ElasApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasApplication.class, args);
    }
}
