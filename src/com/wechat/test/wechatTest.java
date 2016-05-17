package com.wechat.test;

import com.wechat.po.AccessToken;
import com.wechat.util.wechatUtil;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by jiangyiming on 5/15/16.
 */
public class wechatTest {
    public static void main(String[] args) {
        AccessToken token = wechatUtil.getAccessToken();
        System.out.println("票据"+token.getToken());
        System.out.println("有效时间"+token.getExpires_in());
        String path ="/Users/jiangyiming/Pictures/erha.jpg";
        try {
            String mediaId = wechatUtil.upload(path, token.getToken(), "image");
            System.out.println(mediaId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
