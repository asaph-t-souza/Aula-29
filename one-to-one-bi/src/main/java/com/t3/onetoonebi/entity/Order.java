package com.t3.onetoonebi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@Getter @Setter @NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="order_code")
    private String orderCode;

    private int weight;

    private int price;

    private String status;

    //Lado Inverso
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
    private Address addressId;

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderCode=" + orderCode + ", weight=" + weight + ", price=" + price + ", status="
                + status + "]";
    } 
    
}
