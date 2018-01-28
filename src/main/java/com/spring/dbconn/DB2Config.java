package com.spring.dbconn;

import com.spring.dbconn.comm.DBConfig;
import com.spring.dbconn.properties.DB2Properties;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DB2Properties.class)
public class DB2Config extends DBConfig {
    @Autowired
    private DB2Properties properties;

    // DataSource 를 구성하는 빈이름을 db2DataSource 로 지정한다.
    @Bean(name = "db2DataSource", destroyMethod = "close")
    public DataSource dataSource() {
        System.out.println("================== DB2 Config: ");
        System.out.println(properties.toString());
        return new HikariDataSource(configureDataSource(properties));
    }


    @Bean(name = "db2TransactionManager")
    public PlatformTransactionManager userTransactionManager(@Qualifier("db2DataSource") DataSource ds) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(ds);
        transactionManager.setGlobalRollbackOnParticipationFailure(false);
        return transactionManager;
    }
}
