package cn.atsuc.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author csuporg
 * @date 2024/5/9 0:22
 * @email s202011105851@163.com
 * @description
 */
@Configuration // 作为配置类， 代替xml文件
@ComponentScan(basePackages = "cn.atsuc.spring.annotation") // 扫描包
public class springConfig {
}
