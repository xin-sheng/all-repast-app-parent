package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * 存储产品参数信息的表
 */
@Table(name = "pms_product_attribute_value")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class ProductAttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_attribute_id")
    private Long productAttributeId;

    /**
     * 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
     */
    private String value;


}