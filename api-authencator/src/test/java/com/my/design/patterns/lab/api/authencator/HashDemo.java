package com.my.design.patterns.lab.api.authencator;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

/**
 * @author zhangkun
 */
public class HashDemo {
    public static void main(String[] args) {
        String str = "http://www.baidu.com";
        HashFunction hashFunction = Hashing.goodFastHash(128);
        HashCode hash = hashFunction.newHasher().putString(str, StandardCharsets.UTF_8)
                .hash();
        String token = hash.toString();
        System.out.println(token);
    }
}
