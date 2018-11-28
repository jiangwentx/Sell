package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: sell
 * @description: 产品目录数据库映射类
 * @author: Mr.Jiang
 * @create: 2018-11-17 17:07
 **/
@Entity
@DynamicUpdate /*数据库更新，自动更新数据库更新时间*/
@Data  /*lombak不需要get set方法*/
public class ProductCategory {
    /** 类目ID*/
    /*主键自增*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名称*/
    private String categoryName;

    /** 类目编号*/
    private Integer categoryType;

    public ProductCategory(){

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    //    /** 创建时间*/
//    private Date createTime;
//
//    /** 更新时间*/
//    private Date updateTime;
}

