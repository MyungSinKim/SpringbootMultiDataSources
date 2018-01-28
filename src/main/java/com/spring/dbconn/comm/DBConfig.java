package com.spring.dbconn.comm;

import com.zaxxer.hikari.HikariConfig;

import javax.sql.DataSource;

/**
 * 여기는 DB 연결 할 때 설정될 것을 추상클래스로 선언함.
 *  사용되는 JDBC Connection Pool 은 Hikari 을 사용.
 *      참조사이트: https://github.com/brettwooldridge/HikariCP
 */
public abstract class DBConfig {
    public abstract DataSource dataSource();

    protected HikariConfig configureDataSource(DatabaseProperties properties) {
        HikariConfig cfg = new HikariConfig();

        // 드라이브
        cfg.setDriverClassName(properties.getDriverClassName());
        // URL
        cfg.setJdbcUrl(properties.getUrl());
        // 유저 ID
        cfg.addDataSourceProperty("user", properties.getUserName());
        // 비밀번호
        cfg.addDataSourceProperty("password", properties.getPassword());

        // POOL 이름
        cfg.setPoolName(properties.getPoolName());
        // 연결되는지 확인하는 테스트 쿼리 (Mysql, ORALE 공통사용가능)
        cfg.setConnectionTestQuery("SELECT 1 FROM DUAL");
        // This property controls the minimum number of idle connections that HikariCP tries to maintain in the pool
        cfg.setMinimumIdle(properties.getMinimumIdle());
        // This property controls the maximum size that the pool is allowed to reach, including both idle and in-use connections.
        cfg.setMaximumPoolSize(properties.getMaximumPoolSize());
        // maximum lifetime of a connection in the pool.
        cfg.setMaxLifetime(properties.getMaxLifetime());
        // This property controls the maximum amount of time that a connection is allowed to sit idle in the pool
        cfg.setIdleTimeout(properties.getIdleTimeout());
        // This property controls the maximum number of milliseconds that a client (that's you) will wait for a connection from the pool.
        cfg.setConnectionTimeout(properties.getConnectionTimeout());

        System.out.println("히카리 CFG: " + cfg.toString());
        return cfg;
    }
}
