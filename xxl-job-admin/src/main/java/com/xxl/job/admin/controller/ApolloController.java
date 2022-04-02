package com.xxl.job.admin.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>description<p/>
 *
 * @author likun
 * @date： 2022/4/1 9:50
 */
@RestController
@RequestMapping("/apollo")
public class ApolloController {

    @GetMapping("/config/get/{key}")
    public String getApolloConfig(@PathVariable("key") String key) {
        Config appConfig = ConfigService.getAppConfig();
        String value = appConfig.getProperty(key, "");
        return String.format("key: %s, value: %s", key, value);
    }


}
