package com.pluralsight.conferencedemo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ticket_types")
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_type_code", nullable = false)
    private Character ticket_type_code;
    private String ticket_type_name;
    private String description;
    private Boolean include_workshop;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TicketPrice> prices = new ArrayList<>();

    public TicketType() {
    }

    public Character getTicket_type_code() {
        return ticket_type_code;
    }

    public void setTicket_type_code(Character ticket_type_code) {
        this.ticket_type_code = ticket_type_code;
    }

    public String getTicket_type_name() {
        return ticket_type_name;
    }

    public void setTicket_type_name(String ticket_type_name) {
        this.ticket_type_name = ticket_type_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInclude_workshop() {
        return include_workshop;
    }

    public void setInclude_workshop(Boolean include_workshop) {
        this.include_workshop = include_workshop;
    }

    public List<TicketPrice> getPrices() {
        return prices;
    }

    public void setPrices(List<TicketPrice> prices) {
        this.prices = prices;
    }
}
