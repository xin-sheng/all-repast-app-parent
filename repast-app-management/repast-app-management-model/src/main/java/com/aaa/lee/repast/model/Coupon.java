package com.aaa.lee.repast.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠卷表
 */
@Table(name = "sms_coupon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    @NotNull
    private Long id;
    @Column(name = "shop_id")
    private Long shopId;
    @Column(name = "type")
    private Integer type;
    @Column(name = "name")
    private String name;
    @Column(name = "platform")
    private Integer platform;
    @Column(name = "count")
    private Integer count;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "per_limit")
    private Integer perLimit;
    @Column(name = "min_point")
    private BigDecimal minPoint;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "use_type")
    private Integer useType;
    @Column(name = "note")
    private String note;
    @Column(name = "publish_count")
    private Integer publishCount;
    @Column(name = "use_count")
    private Integer useCount;
    @Column(name = "receive_count")
    private Integer receiveCount;
    @Column(name = "enable_time")
    private Date enableTime;
    @Column(name = "code")
    private String code;
    @Column(name = "member_level")
    private Integer memberLevel;

}