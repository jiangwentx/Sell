package com.imooc.sell.dto;

import lombok.Data;

/**
 * @program: sell
 * @description:购物车
 * @author: Mr.Jiang
 * @create: 2018-11-19 15:00
 **/
@Data
public class CartDTO {
    /** 商品Id. */
    private String prodcutId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String prodcutId, Integer productQuantity) {
        this.prodcutId = prodcutId;
        this.productQuantity = productQuantity;
    }
}

