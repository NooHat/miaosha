package com.nohat.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 95
 * @Title: RedisConfig
 * @ProjectName miaosha
 * @Description: TODO
 * @date 2019/3/99:55
 */
@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private int port;
    private int timeout;
    private String password;
    private int poolMaxTotal;
    private int poolMaxIdel;
    private int poolMaxWait;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolMaxTotal() {
        return poolMaxTotal;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public int getPoolMaxIdel() {
        return poolMaxIdel;
    }

    public void setPoolMaxIdel(int poolMaxIdel) {
        this.poolMaxIdel = poolMaxIdel;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }
}
