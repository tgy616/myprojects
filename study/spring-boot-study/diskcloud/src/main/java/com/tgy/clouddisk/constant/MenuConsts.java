package com.tgy.clouddisk.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单配置
 * @author tanggy
 * @date 2018/11/1
 */
public class MenuConsts {
    private static final List<String> MENU = new ArrayList<>();

    static {
        MENU.add("recent");
        MENU.add("disk");
        MENU.add("doc");
        MENU.add("photo");
        MENU.add("video");
        MENU.add("audio");
        MENU.add("safebox");
        MENU.add("share");
        MENU.add("recycle");
    }

    public static List<String> getConsts() {
        return MENU;
    }
}
