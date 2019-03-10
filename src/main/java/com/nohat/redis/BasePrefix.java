package com.nohat.redis;

/**
 * @author 95
 * @Title: BasePrefix
 * @ProjectName miaosha
 * @Description: TODO
 * @date 2019/3/919:36
 */
public abstract class BasePrefix implements KeyPrefix {
    private int expireSeconds;
    private String prefix;
    public BasePrefix(String prefix){
        this(0, prefix);
    }
    @Override
    public int getExpireSeconds() { //默认0代表永不过期
        return this.expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
    public BasePrefix(int expireSeconds,String prefix){
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;

    }


}
