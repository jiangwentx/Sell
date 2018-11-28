package com.imooc.sell.exception;

import enums.ResultEnum;

/**
 * @program: sell
 * @description: 异常
 * @author: Mr.Jiang
 * @create: 2018-11-18 19:54
 **/

public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code = code;
    }
}

