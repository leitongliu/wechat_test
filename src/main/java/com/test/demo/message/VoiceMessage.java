package com.test.demo.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : leitong
 * @date : 2021-10-16 23:30:52
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoiceMessage {

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
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private long MediaId;
    /**
     * 语音格式，如amr，speex等
     */
    private String Format;

}
