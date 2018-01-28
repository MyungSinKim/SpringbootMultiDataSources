package com.svc.test.mapper;

import com.spring.mybatis.comm.DB1Schema;

import java.util.Map;

// DB1MybatisConfig 에서 만든 어노테이션으로 설정된 DB 접속에 사용.
@DB1Schema
public interface Test1Mapper {
    Map selectTest();
}
