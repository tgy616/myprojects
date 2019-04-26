package com.tgy.sbwebjsp.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tanggy
 * @date 2018/10/31
 */
public class MD5Mapper {
    public static final ConcurrentHashMap<String, com.tgy.sbwebjsp.model.File> MAP = new ConcurrentHashMap();

    public MD5Mapper() {
    }
}
