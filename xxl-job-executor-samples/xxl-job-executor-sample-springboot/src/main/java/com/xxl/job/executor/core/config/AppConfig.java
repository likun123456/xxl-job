package com.xxl.job.executor.core.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date 2022/4/1 9:43
 */
@Configuration
@EnableApolloConfig
public class AppConfig {

    @Bean
    public ApolloJavaConfigBean getApolloJavaConfigBean() {
        return new ApolloJavaConfigBean();
    }
}
