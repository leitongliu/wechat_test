package com.test.demo.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : leitong
 * @date : 2021-10-17 22:39:37
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voice {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;

}
