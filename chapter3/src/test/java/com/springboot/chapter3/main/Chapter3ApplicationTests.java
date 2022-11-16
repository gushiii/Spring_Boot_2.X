package com.springboot.chapter3.main;

import com.springboot.chapter3.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootTest
class Chapter3ApplicationTests {

	@Test
	void test01() {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		applicationContext.getEnvironment().setActiveProfiles("dev","test");
		//3. 注册主配置类
		applicationContext.register(AppConfig.class);
		//4. 启动刷新容器
//		applicationContext.refresh();

		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		System.out.println(Arrays.toString(beanNamesForType));

		applicationContext.close();

	}

	@Test
	void test02() {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
		System.out.println(Arrays.toString(beanNamesForType));

		applicationContext.close();

	}

}
