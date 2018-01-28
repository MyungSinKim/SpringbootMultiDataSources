package com.spring.mybatis;

import com.spring.mybatis.comm.DB1Schema;
import com.spring.mybatis.comm.MybatisConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * MapperScan 옵션 설명
 *      basePackages: 매퍼 인터페이스 파일이 있는 가장 최상위 패키지
 *      annotationClass: 매퍼를 지정하는 어노테이션클래스
 *          사용이유: basePackage 를 이용해서 할 수도 있지만, 하위에 interface가 섞여있을 경우 해당 인터페이스가 mapper 인지 인지가 안되는 경우가 있다.
 *              그래서 mapper 클래스를 사용할때 이것을 어노테이션으로 지정해두면, 해당 인터페이스가 mapper 인지를 인지할 수 있다.(어노테이션이 걸려잇는 클래스는 빈클래스이다)
 *      sqlSessionFactoryRef: DB를 여러개 붙어야 하는 경우, 사용되는 세션팩토리를 지정.
 */
@Configuration
@MapperScan(basePackages = MybatisConfig.BASE_PACKAGE, annotationClass = DB1Schema.class, sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DB1MybatisConfig extends MybatisConfig {

    // 해당 빈의 이름을 test1SqlSessionFactory 로 지정한다.
    @Bean(name="db1SqlSessionFactory")
    @Primary
    // dataSource가 2개이상일 경우, 특정 DataSource를 사용해야 하기 때문에 @Qualifier 을 이용하여 사용.
    public SqlSessionFactory sqlSessionFactory(@Qualifier("db1DataSource") DataSource ds) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        configureSqlSessionFactory(sessionFactoryBean, ds);
        return sessionFactoryBean.getObject();
    }
}
