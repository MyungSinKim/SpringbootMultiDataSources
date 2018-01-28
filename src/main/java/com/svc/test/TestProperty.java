package com.svc.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 프로퍼티 값을 제대로 불러내는지 확인하는 클래스
 */
//@Component
public class TestProperty {

    // 기본파일의 hello 메세지
    @Value("${property.hello}")
    private String profiles;

    @Value("${property.message}")
    private String message_0;

    // 다른파일1 - config.xml
    @Value("${conf_1.message}")
    private String message_1;

    // 다른파일2 - config2.xml
    @Value("${conf_2.message}")
    private String message_2;

    // 빈으로 생성되면서 우선으로 실행되도록 한다.(@PostConstruct)
    @PostConstruct
    public void init(){
        System.out.println("Test Class @PostConstruct ======");
        System.out.println(profiles);
        System.out.println(message_0);
        System.out.println(message_1);
        System.out.println(message_2);
    }
}
