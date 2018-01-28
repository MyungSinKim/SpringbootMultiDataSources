package com.spring.mybatis.comm;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

public abstract class MybatisConfig {
    public static final String BASE_PACKAGE = "com";    // 매퍼 인터페이스 파일이 있는 가장 최상위 패키지
    public static final String TYPE_ALIAS_PACKAGE = "com";  // com 아래의 model 클래스 이름을 짧은 별칭으로 등록
    /*
        ## TYPE_ALIAS_PACKAGE (setTypeAliasesPackage) 용도.
        mybatis에서 resultType과 parameterType 사용시 bean 객체를 사용할려면 패키지 경로 및 bean 클래스명까지 입력해야 한다.
        하지만 alias 처리를 해주면 bean 클래스명만 입력하면 되므로 조금 간소해진다.
        ex ) MemberBean 을 사용할 경우 com.test.web.member.bean.MemberBean --> memberBean
        출처: http://anis0721.tistory.com/17
     */
    public static final String CONFIG_PATH = "classpath:mybatis-config.xml";    // mybatis 의 설정파일
    public static final String MAPPER_PATH = "classpath:mapper/**/*.xml";              // mapper를 모아둔 곳
    public static final String MAPPER_PATH2 = "classpath:mapper/**/**/*.xml";              // mapper를 모아둔 곳

    protected void configureSqlSessionFactory(SqlSessionFactoryBean sessionFactoryBean, DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver pathResolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setDataSource(dataSource);
        //sessionFactoryBean.setTypeAliasesPackage(TYPE_ALIAS_PACKAGE);
        sessionFactoryBean.setConfigLocation(pathResolver.getResource(CONFIG_PATH));
        // 2개 이상의 패턴을 넣어야 할때 아래처럼 여러번 넣으면 됨.
        sessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_PATH));
        sessionFactoryBean.setMapperLocations(pathResolver.getResources(MAPPER_PATH2));
    }
}
