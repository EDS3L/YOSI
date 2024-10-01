package com.yosi.model;

import jakarta.persistence.*;
import org.hibernate.query.Order;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long nip;
    private String city;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderAddress> orderAddress;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shipment> shipments;

    public Client() {
    }

    public Client(String name, long nip, String city) {
        this.name = name;
        this.nip = nip;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<OrderAddress> getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(List<OrderAddress> orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip=" + nip +
                ", city='" + city + '\'' +
                ", orderAddress=" + orderAddress +
                ", shipments=" + shipments +
                '}';
    }
}
