package com.svc.test.mapper;

import com.spring.mybatis.comm.DB2Schema;

import java.util.Map;

// DB2MybatisConfig 에서 만든 어노테이션으로 설정된 DB 접속에 사용.
@DB2Schema
public interface Test2Mapper {
    Map selectTest();
}
