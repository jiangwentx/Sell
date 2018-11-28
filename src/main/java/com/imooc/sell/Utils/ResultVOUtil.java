package com.imooc.sell.Utils;

import com.imooc.sell.VO.ResultVO;
import lombok.Data;

import javax.xml.transform.Result;

/**
 * @program: sell
 * @description:
 * @author: Mr.Jiang
 * @create: 2018-11-18 14:55
 **/
@Data
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}

