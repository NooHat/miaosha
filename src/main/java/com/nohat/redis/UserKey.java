package com.nohat.redis;

/**
 * @author 95
 * @Title: UserKey
 * @ProjectName miaosha
 * @Description: TODO
 * @date 2019/3/920:05
 */
public class UserKey extends BasePrefix{
    private UserKey(String prefix){
        super(prefix);

    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey(("name"));
}
