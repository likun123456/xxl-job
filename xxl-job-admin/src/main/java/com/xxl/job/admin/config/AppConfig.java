package com.xxl.job.admin.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
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

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent configChangeEvent) {
        System.out.println("Changes for namespace " + configChangeEvent.getNamespace());
        for (String changeKey : configChangeEvent.changedKeys()) {
            ConfigChange change = configChangeEvent.getChange(changeKey);
            System.out.printf("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s%n", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
        }
    }
}
