package com.xometry.sonderlieferungen.model;

import javax.persistence.*;

/**
 * Simple JavaBean domain object that represents Customer.
 */

@Entity
@Table(name = "sonderlieferungen")
public class Logistics extends  BaseEntity {



    public Logistics() {
    }

    @Column(name = "order_number")
    private String order_number;

    @Column(name = "logistic_aggregator")
    private String logistic_aggregator;

    @Column(name = "logistic_operator")
    private String logistic_operator;

    @Column(name = "delivery_order_nmb")
    private String delivery_order_nmb;

    @Column(name = "gross_price")
    private Double gross_price;

    @Column(name = "net_price")
    private Double net_price;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date_of_booking")
    private String date_of_booking;

    @Column(name = "status")
    private String status;



    public String getOrder() {
        return order_number;
    }

    public void setOrder(String order_number) {
        this.order_number = order_number;
    }

    public String getLogistic_aggregator() {
        return logistic_aggregator;
    }

    public void setLogistic_aggregator(String logistic_aggregator) {
        this.logistic_aggregator = logistic_aggregator;
    }

    public String getLogistic_operator() {
        return logistic_operator;
    }

    public void setLogistic_operator(String logistic_operator) {
        this.logistic_operator = logistic_operator;
    }

    public String getDelivery_order_nmb() {
        return delivery_order_nmb;
    }

    public void setDelivery_order_nmb(String delivery_order_nmb) {
        this.delivery_order_nmb = delivery_order_nmb;
    }

    public Double getGross_price() {
        return gross_price;
    }

    public void setGross_price(Double gross_price) {
        this.gross_price = gross_price;
    }

    public Double getNet_price() {
        return net_price;
    }

    public void setNet_price(Double net_price) {
        this.net_price = net_price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate_of_booking() {
        return date_of_booking;
    }

    public void setDate_of_booking(String date_of_booking) {
        this.date_of_booking = date_of_booking;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "order_number='" + order_number + '\'' +
                ", logistic_aggregator='" + logistic_aggregator + '\'' +
                ", logistic_operator='" + logistic_operator + '\'' +
                ", delivery_order_nmb='" + delivery_order_nmb + '\'' +
                ", gross_price=" + gross_price +
                ", net_price=" + net_price +
                ", reason='" + reason + '\'' +
                ", date_of_booking='" + date_of_booking + '\'' +
                ", status='" + status + '\'' +
                '}';


    }
}
