package com.spring.dbconn.comm;

/**
 * DatabaseProperties 인터페이스
 */
public interface DatabaseProperties {
    String getDriverClassName();
    String getUrl();
    String getUserName();
    String getPassword();
    String getPoolName();
    int getMinimumIdle();
    int getMaximumPoolSize();
    int getMaxLifetime();
    int getIdleTimeout();
    int getConnectionTimeout();
}
