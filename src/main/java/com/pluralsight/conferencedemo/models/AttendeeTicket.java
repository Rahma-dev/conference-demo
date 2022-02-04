package com.pluralsight.conferencedemo.models;

import javax.persistence.*;

@Entity(name = "attendee_tickets")
public class AttendeeTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendee_ticket_id", nullable = false)
    private Long attendee_ticket_id;
    private Float net_price;
    @OneToOne
    private Attendee attendee;

    public Long getAttendee_ticket_id() {
        return attendee_ticket_id;
    }

    public void setAttendee_ticket_id(Long attendee_ticket_id) {
        this.attendee_ticket_id = attendee_ticket_id;
    }

    public Float getNet_price() {
        return net_price;
    }

    public void setNet_price(Float net_price) {
        this.net_price = net_price;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

}
