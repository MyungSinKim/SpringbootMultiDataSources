package com.spring.mybatis;

import com.spring.mybatis.comm.DB2Schema;
import com.spring.mybatis.comm.MybatisConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = MybatisConfig.BASE_PACKAGE, annotationClass = DB2Schema.class, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DB2MybatisConfig extends MybatisConfig{

    // 해당 빈의 이름을 test1SqlSessionFactory 로 지정한다.
    @Bean(name="db2SqlSessionFactory")
    // dataSource가 2개이상일 경우, 특정 DataSource를 사용해야 하기 때문에 @Qualifier 을 이용하여 사용.
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db2DataSource") DataSource ds) throws Exception {
        System.out.println("ds2 ====>");
        System.out.println(ds);
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        configureSqlSessionFactory(sessionFactoryBean, ds);
        return sessionFactoryBean.getObject();
    }
}
