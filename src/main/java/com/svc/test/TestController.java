package com.svc.test;

import com.svc.test.mapper.Test1Mapper;
import com.svc.test.mapper.Test2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    // 생성한 test1Mapper 등록
    @Autowired
    private Test1Mapper test1Mapper;

    @Autowired
    private Test2Mapper test2Mapper;

    @RequestMapping("/")
    public String index(){
        Map result1 = test1Mapper.selectTest();     // DB1 번 결과
        Map result2 = test2Mapper.selectTest();     // DB2 번 결과
        System.out.println("DB1: " + result1);
        System.out.println("DB2: " + result2);
        return "테스트 입니다.";
    }
}
