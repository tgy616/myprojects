package com.tgy.clouddisk.service.Impl;


import com.tgy.clouddisk.entity.Image;
import com.tgy.clouddisk.mapper.ImageMapper;
import com.tgy.clouddisk.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tanggy
 * @date 2018/11/1
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public int insertImage(String name, String url, String md5) {
        Image image = new Image(name, url, md5);
        return imageMapper.insert(image);
    }

    @Override
    public Image selectByMd5(String md5) {
        return imageMapper.selectByMd5(md5);
    }
}