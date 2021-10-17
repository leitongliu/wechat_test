package com.test.demo.util;

/**
 * 消息类型枚举
 *
 * @author : leitong
 * @date : 2021-10-16 23:34:51
 **/
public enum MsgTypeEnum {
    TEXT("文本类型", "text"),
    IMAGE("图片类型", "image"),
    VOICE("语音类型", "voice");

    private final String name;
    private final String value;

    MsgTypeEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
