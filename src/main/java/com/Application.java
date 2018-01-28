package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
    // 프로퍼티 파일 관리
    // application.yml 은 자동으로 읽기 때문에 추가하지 않는다.
    static final String properties = "spring.config.location=classpath:/config.yml, classpath:/config2.yml";

    // Tomcat을 사용할 경우 main 메서드를 타지않게 되기 때문에
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class).properties(properties);
    }

    public static void main(String[] args){
        //SpringApplication.run(Application.class, args);       // 이전에 여러개 Properties 를 참조하지 않았을때 사용한 것.

        // properties 파일이 여러개일때, 프로퍼티를 추가할 때 사용. 추후, 아래의 것은 Config 클래스로 분리해서 사용하는것도 관리방법.
        new SpringApplicationBuilder(Application.class).properties(properties).run(args);
    }
}