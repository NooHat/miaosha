package com.nohat.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 95
 * @Title: RedisService
 * @ProjectName miaosha
 * @Description: TODO
 * @date 2019/3/99:59
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /**
    　　* @Description: 获取对象
    　　* @param
    　　* @return
    　　* @throws
    　　* @author 95
    　　* @date 2019/3/9 21:30
    　　*/
    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            String str = jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;

        }finally {
            returnToPool(jedis);
        }



    }
    /**
    　　* @Description: 设置对象
    　　* @param
    　　* @return
    　　* @throws
    　　* @author 95
    　　* @date 2019/3/9 21:30
    　　*/
    public <T> boolean set(KeyPrefix prefix,String key,T value){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey=prefix.getPrefix()+key;
            String str = beanToString(value);
            if(str == null || str.length()<=0)
                return false;
            if(prefix.getExpireSeconds()>0)
                jedis.set(realKey,str);
            else
                jedis.setex(realKey, prefix.getExpireSeconds(), str);



            return true;

        }finally {
            returnToPool(jedis);
        }



    }

    public <T>boolean exsits(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.exists(realKey);
        }finally {
            returnToPool(jedis);
        }
    }
/**
　　* @Description: 值增加1
　　* @param
　　* @return
　　* @throws
　　* @author 95
　　* @date 2019/3/9 21:37
　　*/
    public <T>Long incr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }
/**
　　* @Description: 值减少1
　　* @param
　　* @return
　　* @throws
　　* @author 95
　　* @date 2019/3/9 21:37
　　*/
    public <T>Long decr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            String realKey = prefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value) {
        if(value == null)
            return null;
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz== Integer.class){
                return ""+value;
        }else if(clazz == String.class){
                return (String)value;
        }else if(clazz == long.class || clazz ==Long.class){
            return "" + value;
        }else{
            return JSON.toJSONString(value);
        }

    }

    private <T> T stringToBean(String str,Class<T> clazz) {
        if(str == null || str.length()<=0 || clazz ==null)
            return null;
        if(clazz == int.class || clazz== Integer.class){
            return (T) Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz ==Long.class){
            return (T) Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private void returnToPool(Jedis jedis) {
        if(jedis != null)
            jedis.close();
    }


}
