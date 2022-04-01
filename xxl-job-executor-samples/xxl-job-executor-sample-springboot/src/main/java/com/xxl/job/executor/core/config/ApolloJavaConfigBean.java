package com.xxl.job.executor.core.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date：2022/4/1 9:41
 */
public class ApolloJavaConfigBean {
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
