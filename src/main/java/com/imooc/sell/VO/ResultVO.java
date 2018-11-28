package com.imooc.sell.VO;

import lombok.Data;

/**
 * @program: sell
 * @description: http请求返回最外层的对象
 * @author: Mr.Jiang
 * @create: 2018-11-17 23:43
 **/
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息*/
    private String msg;

    /** 具体内容*/
    private T data;
}

