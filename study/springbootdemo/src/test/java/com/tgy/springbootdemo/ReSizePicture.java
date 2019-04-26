package com.tgy.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanggy
 * @date 2018/11/13
 */
public class ReSizePicture {
    @Test
    public void plusSize(){
        String url1="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/5/9ade0042231b4baeab7729c1a9b32b11.jpg";
        String url2="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/6/494c4016df3444c0a50011787d688f83.png";
        String url3="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/6/db50c9fa093b4a97afe2dbf256eec1df.png";//5.6M
        String backAdd="?x-oss-process=image/info";
        try {
            InputStream inputStream = new URL(url3).openStream();
            BufferedImage bufImg = ImageIO.read(inputStream);//把图片读入到内存中
            System.out.println(bufImg.getHeight());
            System.out.println(bufImg.getWidth());
            //压缩代码
            bufImg = Thumbnails.of(bufImg).size(bufImg.getWidth(), bufImg.getHeight()).outputQuality(0.1).asBufferedImage();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();//存储图片文件byte数组
            ImageOutputStream ios = ImageIO.createImageOutputStream(bos);
            ImageIO.write(bufImg, "jpg", ios); //图片写入到 ImageOutputStream
            InputStream input = new ByteArrayInputStream(bos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void ThumbnailsCompressPic(){
        String url1="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/5/9ade0042231b4baeab7729c1a9b32b11.jpg";
        String url2="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/6/494c4016df3444c0a50011787d688f83.png";
        String url3="https://xcc-file.oss-cn-beijing.aliyuncs.com/xsf-oss/XCC/STORE/2018/11/6/db50c9fa093b4a97afe2dbf256eec1df.png";
        File input = new File("D://resize/72.jpg");
        try {
            Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(2).outputQuality(1.0);
            BufferedImage src = fileBuilder.asBufferedImage();
            Thumbnails.Builder<File> builder = Thumbnails.of(input);
            int size1=src.getHeight();
            int size2=src.getWidth();
            builder.size(size1, size2); //取最大的尺寸变成size，然后等比缩放
            builder.outputQuality(1.0).toFile("D://resize/72_.jpg");
            //Thumbnails.of(input).scale(1.0).outputQuality(quality).toFile(outputFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void reSizePic(){
        List<String> picUrlList=new ArrayList<String>();
        List<String> returnList=new ArrayList<String>();
        String pic4m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/4M.jpg";
        String pic5m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/5M.jpg";
        String pic9m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/9M.jpg";
        String pic10m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/10M.jpg";
        String pic12m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/12M.jpg";
        String pic18m="https://xsf-file-test.oss-cn-hangzhou.aliyuncs.com/xsf-oss/XCC/ReSizeImage/18M.jpg";
        picUrlList.add(pic4m);
        picUrlList.add(pic5m);
        picUrlList.add(pic9m);
        picUrlList.add(pic10m);
        picUrlList.add(pic12m);
        picUrlList.add(pic18m);
        URL netUrl=null;
        String returnUrl = null;
        try {
            for (int i=0;i<picUrlList.size();i++ ) {
                String url=picUrlList.get(i);
                String url1 = url + "?x-oss-process=image/info";
                netUrl = new URL(url1);
                HttpURLConnection connection = (HttpURLConnection)netUrl.openConnection();
                connection.connect();
                BufferedReader bReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line = null;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bReader.close();
                connection.disconnect();
                JSONObject jsonObject =JSON.parseObject(stringBuilder.toString());
                JSONObject jsonValue =JSON.parseObject(jsonObject.get("FileSize").toString());
                long fileSize= Long.parseLong(jsonValue.get("value").toString());
                fileSize=fileSize/1024/1024;
                if (fileSize>=1 & fileSize <5){
                    returnUrl=url+"?x-oss-process=image/resize,p_30";
                }
                if (fileSize>=5 & fileSize <10){
                    returnUrl=url+"?x-oss-process=image/resize,p_25";
                }
                if (fileSize>=10 & fileSize <15) {
                    returnUrl=url+"?x-oss-process=image/resize,p_20";
                }
                if (fileSize>=15 & fileSize <20){
                    returnUrl=url+"?x-oss-process=image/resize,p_15";
                }
                returnList.add(i,returnUrl);
            }
            System.out.println(returnList);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
