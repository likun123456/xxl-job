package com.xxl.job.admin.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p>apollo config<p/>
 *
 * @author likun
 * @date：2022/4/1 9:41
 */
public class ApolloJavaConfigBean {
    /**
     * 通过AppConfig中的配置，该类中的属性可以通过@Value注解直接获取apollo中的配置
     */
    @Value("${timeout:100}")
    private int timeout;

    @Value("${age:26}")
    private int age;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
