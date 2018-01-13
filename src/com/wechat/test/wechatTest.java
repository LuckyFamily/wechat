package com.wechat.test;

import com.wechat.po.AccessToken;
import com.wechat.util.MessageUtil;
import com.wechat.util.wechatUtil;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureClassLoader;

/**
 * Created by jiangyiming on 5/15/16.
 */
public class wechatTest {
    public static void main(String[] args) {
        AccessToken token = wechatUtil.getAccessToken();
//        System.out.println("票据"+token.getToken());
//        System.out.println("有效时间"+token.getExpires_in());
        //String path ="/Users/jiangyiming/Pictures/erha.jpg";
        try {
            String string=MessageUtil.initImageMessage("me", "you");
            System.out.println(string);
//            String mediaId = wechatUtil.upload(path, token.getToken(), "image");
//            System.out.println(mediaId);

//            JSONObject menu = JSONObject.fromObject(wechatUtil.initMenu());
//            System.out.println(menu);
//            int result = wechatUtil.createMenu(token.getToken(),menu.toString());
//            if (result==0){
//                System.out.println("yes成功");
//            } else{
//                System.out.println("错误码"+result);
//            }
//
//
////            int result = wechatUtil.deleteMenu(token.getToken());
////            if (result==0){
////                System.out.println("delete成功");
////            } else{
////                System.out.println("错误码"+result);
////            }
//
//
//            JSONObject queryMenu = JSONObject.fromObject(wechatUtil.queryMenu(token.getToken()));
//            System.out.println(queryMenu);
//            String source = "百度翻译很坑爹";
//            String result = wechatUtil.translate(source);
//            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
