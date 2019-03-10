package com.nohat.redis;

/**
 * @author 95
 * @Title: KeyPrefix
 * @ProjectName miaosha
 * @Description: TODO
 * @date 2019/3/919:36
 */
public interface KeyPrefix {
    public int getExpireSeconds();
    public String getPrefix();
}
