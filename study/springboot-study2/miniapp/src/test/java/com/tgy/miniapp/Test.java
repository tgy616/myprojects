package com.tgy.miniapp;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tanggy
 * @date 2018/8/13
 */
public class Test {

    private ThreeMetherCreadCodePic threeMetherCreadCodePic=new ThreeMetherCreadCodePic();
    @org.junit.Test
    public void testGetCodePic(){
        String tocken="13_HITBgcSEhPd8YgS0rai9hSYT7kRH6XhNP4lrmTjL3vbzwT_r7AvylrE2K3HN3Ctw9AkwLq56dPx3pNBcEvLHGmqcMU3OKpArMuEFmIewDCzMdBMadF-rkVWtGu4UEvB72vjTb3azDIwhNdcMZTUbAEAHBC";
        String scene="S=9527&D=1";
        String code = threeMetherCreadCodePic.createBCode(tocken, "/index", scene);
        System.out.println(code);
    }
}
