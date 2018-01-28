package com.spring.dbconn;

import com.spring.dbconn.comm.DBConfig;
import com.spring.dbconn.properties.DB1Properties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DB1Properties.class)
public class DB1Config extends DBConfig {
    @Autowired
    private DB1Properties properties;

    // DataSource 를 구성하는 빈이름을 db1DataSource 로 지정한다.
    @Bean(name = "db1DataSource", destroyMethod = "close")
    /**
     * DataSource 가 여러개가 있는 경우 @Primary 가 있는 것이 기본으로 등록되게 된다.
     *  이렇게 등록하는 이유는 다음의 에러를 방지하기 위해서다.
     *      에러: No qualifying bean of type 'javax.sql.DataSource' available: expected single matching bean but found 2: db1DataSource,db2DataSource
     */
    @Primary
    public DataSource dataSource() {
        System.out.println("================== DB1 Config: ");
        System.out.println(properties.toString());
        return new HikariDataSource(configureDataSource(properties));
    }


    @Bean(name = "db1TransactionManager")
    public PlatformTransactionManager userTransactionManager(@Qualifier("db1DataSource") DataSource ds) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(ds);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }
}
