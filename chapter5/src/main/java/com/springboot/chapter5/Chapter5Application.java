package com.springboot.chapter5;

import com.springboot.chapter5.dao.MyBatisUserDao;
import com.springboot.chapter5.plugin.MyPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Properties;

@SpringBootApplication(scanBasePackages = {"com.springboot.chapter5"})
@EnableJpaRepositories(basePackages = "com.springboot.chapter5.dao")
@EntityScan(basePackages = "com.springboot.chapter5.pojo")
@MapperScan(
		basePackages = "com.springboot.chapter5.*",
//		sqlSessionFactoryRef = "sqlSessionFactory",
//		sqlSessionTemplateRef = "sqlSessionTemplate",
		annotationClass = Repository.class
)
public class Chapter5Application {

	@Autowired
	SqlSessionFactory sqlSessionFactory = null;

	@PostConstruct
	public void initMybatis () {
		Interceptor plugin = new MyPlugin();
		Properties properties = new Properties();
		properties.setProperty("key1", "value1");
		properties.setProperty("key2", "value2");
		properties.setProperty("key3", "value3");
		plugin.setProperties(properties);
		sqlSessionFactory.getConfiguration().addInterceptor(plugin);
	}

//	@Bean
//	public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao () {
//		MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
//		bean.setMapperInterface(MyBatisUserDao.class);
//		bean.setSqlSessionFactory(sqlSessionFactory);
//		return bean;
//	}

//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer () {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//		mapperScannerConfigurer.setBasePackage("com.springboot.chapter5.*");
//		mapperScannerConfigurer.setAnnotationClass(Repository.class);
//		return mapperScannerConfigurer;
//	}

	public static void main(String[] args) {
		SpringApplication.run(Chapter5Application.class, args);
	}

}
