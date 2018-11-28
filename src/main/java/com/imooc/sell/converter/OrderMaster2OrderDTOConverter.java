package com.imooc.sell.converter;

import com.imooc.sell.dataobject.OrderMaster;
import com.imooc.sell.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: sell
 * @description:
 * @author: Mr.Jiang
 * @create: 2018-11-21 21:47
 **/

public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return orderMasterList.stream().map(e->
                convert(e)
        ).collect(Collectors.toList());
    }
}

