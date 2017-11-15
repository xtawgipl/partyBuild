package com.tydic.traffic.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.tydic.traffic.page.dialect.DialectType;
import com.tydic.traffic.page.interceptor.PageInterceptor;
import com.tydic.traffic.page.starter.PageProterties;

//@Configuration
//@MapperScan(basePackages = ClusterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "clusterSqlSessionFactory")
public class ClusterDataSourceConfig {

	// 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.tydic.traffic.mapper.cluster";
    static final String MAPPER_LOCATION = "classpath:mapper/cluster/*.xml";
    
    @Bean(name = "clusterDataSource")
	@ConfigurationProperties(prefix = "cluster.datasource")
    public DataSource clusterDataSource() {
        return new DruidDataSource();
    }
 
    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("clusterDataSource") DataSource clusterDataSource) {
        return new DataSourceTransactionManager(clusterDataSource);
    }
 
    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource, 
    		@Qualifier("pageProterties") PageProterties pageProterties) throws Exception {
    	PageInterceptor pageInterceptor = new PageInterceptor();
    	Properties properties = new Properties();
    	properties.setProperty("dialect", DialectType.MYSQL.getDialectName());
    	properties.setProperty("count.isCount", String.valueOf(pageProterties.getCount().isCount()));
    	properties.setProperty("count.expireAfterAccess", String.valueOf(pageProterties.getCount().getExpireAfterAccess()));
    	properties.setProperty("count.maximumSize", String.valueOf(pageProterties.getCount().getMaximumSize()));
    	pageInterceptor.setProperties(properties);
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setPlugins(new Interceptor[] { pageInterceptor });
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
    
}




