package com.tgy.springboottask;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知.今晚开会");
        message.setText("今晚7点半开会！！！");
        message.setTo("tangguangyong@163.com");
        message.setFrom("418982690@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws Exception{
        //创建一个复杂的消息邮件
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

        helper.setSubject("通知.今晚开会");
        helper.setText("<b style='color.red'>今晚7点半开会！！！</b>",true);
        helper.setTo("tangguangyong@163.com");
        helper.setFrom("418982690@qq.com");
        helper.addAttachment("1.jpg",new File("d://testPic.jpg"));
        mailSender.send(mimeMailMessage);
    }

}
