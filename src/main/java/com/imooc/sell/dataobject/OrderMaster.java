package com.imooc.sell.dataobject;

import enums.OrderStatusEnum;
import enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: sell
 * @description: 订单主表对象
 * @author: Mr.Jiang
 * @create: 2018-11-18 15:21
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**支付状态，默认为0未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    private Date updateTime;


}

