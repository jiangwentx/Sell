package com.imooc.sell.Utils;

import enums.CodeEnum;
import lombok.Data;

/**
 * @program: sell
 * @description:
 * @author: Mr.Jiang
 * @create: 2018-11-26 15:22
 **/
@Data
public class EnumUtil {
    //T是实现了codeEnum接口的类
    public static <T extends CodeEnum> T getByCode(Integer code,Class<T> enumClass){
        for(T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}

