package com.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.wechat.po.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class MessageUtil {
    //xml转map集合/
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_NEWS = "news";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();
        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    //文本对象转成xml
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    //图文对象转成xml
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }

    public static String initNewsMessage(String toUserName,String fromUserName){
        String message = null;
        List<News> newsList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();
        News news = new News();
        news.setTitle("第一枚自己实现的微信服务器后台发出来的文章");
        news.setDescription("这只是一个超链接...");
        news.setPicUrl("http://www.baidu.com/img/bd_logo1.png");
        news.setUrl("www.baidu.com");
        newsList.add(news);
        newsMessage.setFromUserName(toUserName);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticleCount(newsList.size());
        newsMessage.setArticles(newsList);
        message = newsMessageToXml(newsMessage);
        return message;
    }


    public static String initImageMessage(String toUserName, String fromUserName){
        String message = null;
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setFromUserName(toUserName);
        imageMessage.setToUserName(fromUserName);
        imageMessage.setMsgType(MESSAGE_IMAGE);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setMediaId("es4VFubag5vzrVQOILxKVQBvM5Rdnvr1lSPsm3dJPztHLzR2ekhpAPaE7RqRb_-k");
        imageMessage.setPicUrl("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=R1ejjL0eFuiFkk6plCfluhsICX5cqaQYoOSgedYQCt8o17afbldCFC3EzZwt7iTiBw9IMljKHkjRjyBZB_n2JAtbJWFzdfUjrhXo7RjDXfPI8CASubib2U3GbCjLkDQMXSCgADARMW&media_id=es4VFubag5vzrVQOILxKVQBvM5Rdnvr1lSPsm3dJPztHLzR2ekhpAPaE7RqRb_-k");
        imageMessage.setMsgId("2134567890123456");
        message = imageMessageToXml(imageMessage);
        return message;
    }

    public static String imageMessageToXml(ImageMessage imageMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }

    public static String initMusicMessage(String toUserName,String fromUserName){
        String message= null;
        Music music = new Music();
        music.setThumbMediaId("");//要获取!!!!!!test里
        music.setTitle("see you again");
        music.setDescription("C U Again");
        music.setHQMusicUrl("http://wewechat.duapp.com/wechat/music/SeeYouAgain.mp3");//路径==公网+/resources~~~
        music.setMusicUrl("http://wewechat.duapp.com/wechat/music/SeeYouAgain.mp3");//同上
        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setFromUserName(toUserName);
        musicMessage.setToUserName(fromUserName);
        musicMessage.setMsgType(MESSAGE_MUSIC);
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMusic(music);
        message = musicMessageToXml(musicMessage);
        return message;
    }

    public static String musicMessageToXml(MusicMessage musicMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage text = new TextMessage();
        text.setToUserName(fromUserName);
        text.setFromUserName(toUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return MessageUtil.textMessageToXml(text);
    }
    /**
     * 主菜单
     * @return
     */
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("1.test\n");
        sb.append("2.一条图文消息\n\n");
        sb.append("回复 ? 调出此菜单~~");
        sb.append("以任何一种语言发送任何文字最后都会翻译成英文~~欢迎调戏");
        return sb.toString();
    }

    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("对!没错!你按了1...\n\n");
        sb.append("回复 ? 调出主菜单~~");
        return sb.toString();
    }

    public static String subscribeMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("吼吼~~怎么才关注我咧~~请按菜单提示进行操作!么么扎\n\n");
        sb.append("1.test\n");
        sb.append("2.一条图文消息\n\n");
        sb.append("回复 ? 调出此菜单~~");
        sb.append("以任何一种语言发送任何文字最后都会翻译成英文~~欢迎调戏");
        return sb.toString();
    }
}
