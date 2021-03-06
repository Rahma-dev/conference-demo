package com.pluralsight.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "ticket_prices")
public class TicketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_price_id", nullable = false)
    private Long ticket_price_id;
    private Float base_price;

    @ManyToOne(cascade = CascadeType.ALL)
    private PriceCategory priceCategory;

    @OneToOne(cascade = CascadeType.ALL)
    private TicketType ticketType;

    public Long getTicket_price_id() {
        return ticket_price_id;
    }

    public void setTicket_price_id(Long ticket_price_id) {
        this.ticket_price_id = ticket_price_id;
    }

    public Float getBase_price() {
        return base_price;
    }

    public void setBase_price(Float base_price) {
        this.base_price = base_price;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}
