package com.pluralsight.conferencedemo.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "pricing_categories")
public class PriceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pricing_category_code", nullable = false)
    private String pricing_category_code;
    private String pricing_category_name;
    private Date pricing_start_date;
    private Date pricing_end_date;

    @OneToMany
    private List<TicketPrice> prices = new ArrayList<>();

    public String getPricing_category_code() {
        return pricing_category_code;
    }

    public void setPricing_category_code(String pricing_category_code) {
        this.pricing_category_code = pricing_category_code;
    }

    public String getPricing_category_name() {
        return pricing_category_name;
    }

    public void setPricing_category_name(String pricing_category_name) {
        this.pricing_category_name = pricing_category_name;
    }

    public Date getPricing_start_date() {
        return pricing_start_date;
    }

    public void setPricing_start_date(Date pricing_start_date) {
        this.pricing_start_date = pricing_start_date;
    }

    public Date getPricing_end_date() {
        return pricing_end_date;
    }

    public void setPricing_end_date(Date pricing_end_date) {
        this.pricing_end_date = pricing_end_date;
    }

    public List<TicketPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<TicketPrice> prices) {
        this.prices = prices;
    }
}
