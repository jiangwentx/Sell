package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.Utils.EnumUtil;
import com.imooc.sell.Utils.serializer.Date2LongSerializer;
import com.imooc.sell.dataobject.OrderDetail;
import enums.OrderStatusEnum;
import enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: 各个层之间传递参数的对象
 * @author: Mr.Jiang
 * @create: 2018-11-18 19:34
 **/
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /** 订单id*/
    private String orderId;

    /** 买家名字*/
    private String buyerName;

    /* 买家手机号*/
    private String buyerPhone;

    /** 买家地址*/
    private String buyerAddress;

    /** 买家微信id*/
    private String buyerOpenid;

    /**订单总金额 */
    private BigDecimal orderAmount;

    /**订单状态 默认0为新下单*/
    private Integer orderStatus;

    /**支付状态，默认为0未支付 */
    private Integer payStatus;

    /** 创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    //JSON格式忽略
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}

