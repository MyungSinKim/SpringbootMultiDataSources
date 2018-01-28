package com.spring.dbconn.properties;

import com.spring.dbconn.comm.DatabaseProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "db1")    // application.xml 에 등록한 db1 프로퍼티 값을 주입함을 의미
@Data       // lombok 을 사용한 것. 만약 lombok 을 사용하지 않는다면 get/set 을 모두 만들어줘야 함.
public class DB1Properties implements DatabaseProperties {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private String poolName;
    private int minimumIdle;
    private int maximumPoolSize;
    private int maxLifetime;
    private int idleTimeout;
    private int connectionTimeout;
}
