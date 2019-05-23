package com.tgy.websocket;

import java.io.Console;

/**
 * 获取酷狗付费音乐临时文件的加密
 *
 * @author DragonSwimDiving
 * @program websocket.demo
 * @Date 2019-05-17 13:47
 **/

public class KugouGetMapFromTemp {
    public static void main(String[] args) {
        KugouTempFileToMp3AndModifyNameToTrueName ktf = new KugouTempFileToMp3AndModifyNameToTrueName();
		String tempPath = "E:\\KuGou\\Temp\\5ba86f188900b8a02e6b6826076cf7f3.kgtemp";
		String krcPath ="E:\\KuGou\\Lyric\\Olly Murs、Veegee - That Girl (Ye Remix)-5ba86f188900b8a02e6b6826076cf7f3-38090220-00000000.krc";
		ktf.Change(tempPath,krcPath);

        /*String tempDir ="D:/KuGou/mp3";
        String krcDir="D:/KuGou/Lyric";
        ktf.ChangeByDir(tempDir, krcDir);*/

    }
}
