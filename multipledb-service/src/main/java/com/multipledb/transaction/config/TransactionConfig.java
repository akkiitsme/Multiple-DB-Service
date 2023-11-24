package com.multipledb.transaction.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "trxEntityManagerFactoryBean",
        basePackages = {"com.multipledb.transaction"},
        transactionManagerRef = "trxTransactionManager"
)
public class TransactionConfig {

    @Autowired
    private Environment env;

    @Bean(name="trxUSDataSource")
    @Primary
    public DataSource dataSourceUS(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.trxus.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.trxus.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.trxus.password"));
        return dataSource;
    }

    @Bean(name="trxUKDataSource")
    @Primary
    public DataSource dataSourceUK(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.trxuk.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.trxuk.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.trxuk.password"));
        return dataSource;
    }

    @Bean
    @Primary
    public RequestContext requestContext() {
        return new RequestContext();
    }

    @Bean
    public DataSourceRouter dataSourceRouter(){
        DataSourceRouter router = new DataSourceRouter();
        // Define data sources for each tenant
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("default", dataSourceUS());
        targetDataSources.put("tenant1", dataSourceUK());
        router.setTargetDataSources(targetDataSources);
       // router.setDefaultTargetDataSource(dataSourceUS());
        return router;
    }


    @Bean(name = "trxEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSourceRouter());
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);
        Map<String, String> props = new HashMap<>();
        //props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(props);
        bean.setPackagesToScan("com.multipledb.transaction");
        return bean;
    }

    @Primary
    @Bean(name="trxTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return  transactionManager;

    }
}
