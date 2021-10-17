package com.test.demo.controller;

import com.test.demo.message.*;
import com.test.demo.util.CheckUtil;
import com.test.demo.util.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author : leitong
 * @date : 2021-10-15 22:42:47
 **/
@RestController
@RequestMapping("/wx")
public class WechatController {

    @GetMapping("/")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();

        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
    }

    @PostMapping("/")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            Map<String, String> map = MessageUtil.xmlToMap(request);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String msgType = map.get("MsgType");
            String mediaId = map.get("MediaId");
            String content = map.get("Content");
            String replyContent = content != null ? (
                    content.contains("刘淼飏")
                            | content.contains("小哥哥")
                            | content.contains("老公")
                            | content.contains("亲爱的")
                            ? "我认识你！你是我家大可爱！"
                            : "你谁呀！我不认识你，请念出你的身份证！") : "";

            String message = null;
            if ("text".equals(msgType)) {
                // 对文本消息进行处理
                TextMessage text = TextMessage.builder()
                        .FromUserName(toUserName)
                        .ToUserName(fromUserName)
                        .MsgType("text")
                        .CreateTime(System.currentTimeMillis())
                        .Content(replyContent)
                        .build();
                message = MessageUtil.textMessageToXML(text);
            }
            if ("image".equals(msgType)) {
                // 对图片消息进行处理
                ImageMessage image = ImageMessage.builder()
                        .FromUserName(toUserName)
                        .ToUserName(fromUserName)
                        .MsgType("image")
                        .CreateTime(System.currentTimeMillis())
                        .Image(Image.builder().MediaId(mediaId).build())
                        .build();
                System.out.println("ok");
                message = MessageUtil.imageMessageToXML(image);
            }
            if ("voice".equals(msgType)) {
                // 对图片消息进行处理
                VoiceMessage voice = VoiceMessage.builder()
                        .FromUserName(toUserName)
                        .ToUserName(fromUserName)
                        .MsgType("voice")
                        .CreateTime(System.currentTimeMillis())
                        .Voice(Voice.builder().MediaId("ygEi-CVz_SvJ1hbbgvwomdj0HGzFGVgxjW9PN3-KksQOfakhS1Y47P-BaC_hskTa").build())
                        .build();
                System.out.println("ok");
                message = MessageUtil.voiceMessageToXML(voice);
            }
            System.out.println(message);
            out.print(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
