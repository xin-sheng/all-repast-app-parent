package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 产品属性分类表
 */
@Table(name = "pms_product_attribute_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class ProductAttributeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    private String name;

    /**
     * 属性数量
     */
    @Column(name = "attribute_count")
    private Integer attributeCount;

    /**
     * 参数数量
     */
    @Column(name = "param_count")
    private Integer paramCount;


}