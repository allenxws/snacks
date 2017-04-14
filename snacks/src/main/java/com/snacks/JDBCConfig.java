package com.snacks;

import com.snacks.common.service.EnvironmentService;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by xuwushun on 2016/10/21.
 */
@Configuration
@ComponentScan(basePackages = "com.snacks.common.service")
public class JDBCConfig {
	@Autowired
	EnvironmentService environmentService;

	@Bean
	public PooledDataSource pooledDataSource() {
		PooledDataSource pooledDataSource = new PooledDataSource();
		pooledDataSource.setUrl(environmentService.getConfig("jdbc.url"));
		pooledDataSource.setUsername(environmentService.getConfig("jdbc.username"));
		pooledDataSource.setPassword(environmentService.getConfig("jdbc.password"));
		pooledDataSource.setDriver(environmentService.getConfig("jdbc.driverClassName"));
		pooledDataSource.setPoolMaximumActiveConnections(Integer.valueOf(environmentService.getConfig("jdbc.maxActive")));
		pooledDataSource.setPoolPingEnabled(true);
		pooledDataSource.setPoolPingQuery("select now() from user limit 1");
		pooledDataSource.setPoolPingConnectionsNotUsedFor(7200000);
		return pooledDataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(pooledDataSource());
		return sqlSessionFactoryBean;
	}


	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(pooledDataSource());
	}
}
