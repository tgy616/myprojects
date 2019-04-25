package com.tgy.springbootcache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author tanggy
 * @date 2018/6/8
 */
@Configuration
@EnableCaching
//@EnableTransactionManagement
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");
        //ConcurrentMapCache personsCache = new ConcurrentMapCache("persons");

        //simpleCacheManager.setCaches(Arrays.asList(cache, personsCache));
        simpleCacheManager.setCaches(Collections.singleton(cache));
        return simpleCacheManager;

    }

}