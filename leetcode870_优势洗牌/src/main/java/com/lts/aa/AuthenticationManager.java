package com.lts.aa;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private final Map<String,Integer> map;

    private final Integer timeToLive;

    public AuthenticationManager(int timeToLive) {
//        初始化哈希表
        map=new HashMap<>();
//        设置过期时间
        this.timeToLive=timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
//        向hash表里面存入tokenID和当前token的过期时刻来实现判断操作
        map.put(tokenId,currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
//        判断给定的tokenId是否过期，如果过期则不操作，若没有过期则将时间延长timeToLive秒
        if(null!=map.get(tokenId)&&currentTime<map.get(tokenId)){
//            tokenId存在且未过期
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
//        打印所有的未过期的tokenID
        int result=0;
        for(String key: map.keySet()){
            if(map.get(key)>currentTime){
                result++;
            }
        }
        return result;
    }
}
