package com.xxl.job.executor.test;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XxlJobExecutorExampleBootApplicationTests {

	@Test
	public void test() {
		// 通过key获取apollo配置中心的value
		Config config = ConfigService.getAppConfig();
		String key = "timeout";
		String value = "200";
		String property = config.getProperty(key, value);
		System.out.println(property);

		config.addChangeListener(configChangeEvent -> {
			System.out.println("Changes for namespace " + configChangeEvent.getNamespace());
			for (String changeKey : configChangeEvent.changedKeys()) {
				ConfigChange change = configChangeEvent.getChange(changeKey);
				System.out.printf("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s%n", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType());
			}
		});
	}

}