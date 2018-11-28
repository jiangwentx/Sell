package com.imooc.sell.Utils;

import lombok.Data;

import java.util.Random;

/**
 * @program: sell
 * @description: 生成唯一主键  时间+六位随机数
 * @author: Mr.Jiang
 * @create: 2018-11-18 20:16
 **/
@Data
public class KeyUtil {
    //多线程锁定，防止生成同样的主键
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        //生成六位随机数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis()+String.valueOf(number);

    }
}

