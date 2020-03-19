package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * 订单操作历史记录
 */
@Table(name = "oms_order_operate_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class OrderOperateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 操作人：用户；系统；后台管理员
     */
    @Column(name = "operate_man")
    private String operateMan;

    /**
     * 操作时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
     * 备注
     */
    private String note;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }


}