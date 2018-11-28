package com.imooc.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;

import java.util.List;

/**
 * @program: sell
 * @description: 商品包含类目
 * @author: Mr.Jiang
 * @create: 2018-11-18 00:03
 **/
@Data
public class ProductVO {

    //序列化给前端,前端得到name
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}

