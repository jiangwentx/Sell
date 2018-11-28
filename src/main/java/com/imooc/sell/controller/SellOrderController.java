package com.imooc.sell.controller;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.OrderService;
import enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @program: sell
 * @description: 卖家端订单
 * @author: Mr.Jiang
 * @create: 2018-11-26 11:06
 **/
@Controller
@Slf4j
@RequestMapping("/seller/order")

public class SellOrderController {

    @Autowired
    private OrderService orderService;
    /*
    * 订单列表
    * @param page 第几页，从1页开始
    * @param size 一共有多少条数据
    * @return
    * */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue ="1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                            Map<String,Object> map){
        PageRequest request = new PageRequest(page-1,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage",orderDTOPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("order/list",map);


    }
    /*
       * 取消订单
       * @param orderId
       * @param map
       * @return
       * */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                                Map<String,Object> map){
        try{
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        }catch (Exception e){
            log.error("【卖家端取消订单】发生异常{}",e);

            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
    /*
       * 订单详情
       * @param orderId
       * @param map
       * @return
       * */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                                Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            map.put("orderDTO",orderDTO);
        }
        catch (Exception e){
            log.error("【卖家端查询订单详情】发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
        }

        return new ModelAndView("/order/detail",map);
    }

}

