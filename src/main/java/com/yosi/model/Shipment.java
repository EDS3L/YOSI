package com.yosi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int weight,width,height,length;
    private String shipmentNumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;



    public Shipment() {
    }

    public Shipment(int weight, int width, int height, int length, String shipmentNumber) {
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
        this.shipmentNumber = shipmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", shipmentNumber=" + shipmentNumber +
                '}';
    }
}
