package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "oms_order_setting")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class OrderSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 正常订单超时时间(分)
     */
    @Column(name = "normal_order_overtime")
    private Integer normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @Column(name = "confirm_overtime")
    private Integer confirmOvertime;

    /**
     * 自动完成交易时间，不能申请售后（天）
     */
    @Column(name = "finish_overtime")
    private Integer finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @Column(name = "comment_overtime")
    private Integer commentOvertime;


}