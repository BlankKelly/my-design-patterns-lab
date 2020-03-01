package com.my.design.patterns.lab.api.authencator;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * <p>
 * token相关的操作
 * </p>
 *
 * @author zhangkun
 */
public class AuthToken {
    /**
     * 默认token过期时间，单位毫秒
     */
    public static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime, Map<String, String> params) {
        StringBuilder unEncodedUrlBuilder = new StringBuilder(baseUrl);

        // 取出appId/pwd
        params.forEach((key, value) -> {
            unEncodedUrlBuilder.append("&").append(key).append("=").append(value);
        });
        unEncodedUrlBuilder.append("&").append("ts=").append(String.valueOf(createTime));

        String unEncodedUrl = unEncodedUrlBuilder.toString();
        HashFunction hashFunction = Hashing.goodFastHash(128);
        HashCode hash = hashFunction.newHasher().putString(unEncodedUrl, StandardCharsets.UTF_8)
                .hash();
        String token = hash.toString();

        return new AuthToken(token, createTime);
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - createTime > expiredTimeInterval;
    }

    public boolean match(AuthToken authToken) {
        return null != authToken && authToken.getToken().equals(token);
    }
}
