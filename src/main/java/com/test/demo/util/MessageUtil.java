package com.test.demo.util;

import com.test.demo.message.ImageMessage;
import com.test.demo.message.TextMessage;
import com.test.demo.message.VoiceMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : leitong
 * @date : 2021-10-15 22:47:22
 **/
public class MessageUtil {

    /**
     * 微信公众号客户端的xml转为map
     *
     * @param request 传入
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {

        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream in = request.getInputStream();
        Document doc = reader.read(in);

        //获取根元素
        Element root = doc.getRootElement();
        //获取所有节点
        List<Element> elements = root.elements();

        elements.forEach(e -> {
            map.put(e.getName(), e.getText());
            System.out.println(e.getName() + "--->" + e.getText());
        });

        in.close();
        return map;

    }

    public static String textMessageToXML(TextMessage message) {
        XStream xStream = new XStream();
        xStream.alias("xml", TextMessage.class);
        return xStream.toXML(message);
    }

    public static String imageMessageToXML(ImageMessage message) {
        XStream xStream = new XStream();
        xStream.alias("xml", ImageMessage.class);
        return xStream.toXML(message);
    }

    public static String voiceMessageToXML(VoiceMessage message) {
        XStream xStream = new XStream();
        xStream.alias("xml", VoiceMessage.class);
        return xStream.toXML(message);
    }
}
