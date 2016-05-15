package com.wechat.test;

import com.wechat.po.AccessToken;
import com.wechat.util.wechatUtil;

/**
 * Created by jiangyiming on 5/15/16.
 */
public class wechatTest {
    public static void main(String[] args) {
        AccessToken token = wechatUtil.getAccessToken();
        System.out.println("票据"+token.getToken());
        System.out.println("有效时间"+token.getExpires_in());
        String path ="";
    }
}
