package com.test.demo.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : leitong
 * @date : 2021-10-15 23:08:11
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextMessage {

    /**
     * 开发者微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long CreateTime;
    /**
     * 消息id，64位整型
     */
    private String MsgType;
    /**
     * 文本消息内容
     */
    private String Content;


}
