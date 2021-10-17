package com.test.demo.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * @author : leitong
 * @date : 2021-10-15 23:17:54
 **/
public class CheckUtil {

    private static final String token = "gallifrey";

    public static boolean checkSignature(String signature, String timestamp, String nonce) {

        String[] arr = new String[]{token, timestamp, nonce};

        Arrays.sort(arr);

        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        String content = builder.toString();

        String temp = getSHA1String(content);

        return temp.equals(signature);

    }

    private static String getSHA1String(String content) {
        return DigestUtils.sha1Hex(content);
    }

}
