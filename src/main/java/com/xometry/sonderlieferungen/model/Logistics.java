package com.xometry.sonderlieferungen.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object that represents Customer.
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "sonderlieferungen")
public class Logistics extends BaseEntity {
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "logistic_aggregator")
    private String logisticAggregator;
    @Column(name = "logistic_operator")
    private String logisticOperator;
    @Column(name = "delivery_order_nmb")
    private String deliveryOrderNmb;
    @Column(name = "gross_price")
    private Double grossPrice;
    @Column(name = "net_price")
    private Double netPrice;
    @Column(name = "reason")
    private String reason;
    @Column(name = "date_of_booking")
    private String dateOfBooking;
    @Column(name = "status")
    private String status;
}
