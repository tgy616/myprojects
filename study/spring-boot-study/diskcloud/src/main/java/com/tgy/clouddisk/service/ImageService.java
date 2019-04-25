package com.tgy.clouddisk.service;

import com.tgy.clouddisk.entity.Image;

/**
 * @author tanggy
 * @date 2018/11/1
 */
public interface ImageService {
    int insertImage(String name, String url, String md5);

    Image selectByMd5(String md5);
}
