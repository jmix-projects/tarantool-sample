package com.company.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "tarantool")
@ConstructorBinding
public class TarantoolProperties {

    private String host;

    private int port;

    private String username;

    private String password;

    public TarantoolProperties(
            @DefaultValue("localhost") String host,
            @DefaultValue("3301") int port,
            @DefaultValue("guest") String username,
            @DefaultValue("") String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
