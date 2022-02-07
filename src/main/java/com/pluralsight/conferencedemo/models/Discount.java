package com.pluralsight.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "discount_codes")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_code_id", nullable = false)
    private Long discount_code_id;
    private String discount_name;
    private String discount_type;
    private Float discount_amount;

    public Discount() {
    }

    public Long getDiscount_code_id() {
        return discount_code_id;
    }

    public void setDiscount_code_id(Long discount_code_id) {
        this.discount_code_id = discount_code_id;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public Float getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(Float discount_amount) {
        this.discount_amount = discount_amount;
    }
}
