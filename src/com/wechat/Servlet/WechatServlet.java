package com.wechat.servlet;

import com.wechat.po.TextMessage;
import com.wechat.util.CheckUtil;
import com.wechat.util.MessageUtil;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by jiangyiming on 5/14/16.
 */
public class WechatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        PrintWriter out = resp.getWriter();
        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            Map<String, String> map = MessageUtil.xmlToMap(req);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");

            String message = null;
            if (MessageUtil.MESSAGE_TEXT.equals(msgType)) {
                if ("1".equals(content)) {
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
                } else if ("2".equals(content)) {
                    message = MessageUtil.initNewsMessage(toUserName, fromUserName);
                } else if ("3".equals(content)) {
                    message = MessageUtil.initImageMessage(toUserName, fromUserName);
                } else if ("4".equals(content)) {
                    message = MessageUtil.initMusicMessage(toUserName, fromUserName);
                }else if ("?".equals(content) || "？".equals(content)) {
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
                }
            } else if (MessageUtil.MESSAGE_EVENT.equals(msgType)) {
                String eventType = map.get("Event");
                if (MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)) {
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.subscribeMenu());
                }
            }
            System.out.println(message);
            out.print(message);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
