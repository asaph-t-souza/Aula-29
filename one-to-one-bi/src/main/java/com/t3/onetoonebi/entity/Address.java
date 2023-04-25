package com.t3.onetoonebi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter @Setter @NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String cep;

    private String street;

    private int number;


    //Lado Dono
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order orderId;

    @Override
    public String toString() {
        return "Address [id=" + id + ", cep=" + cep + ", street=" + street + ", number=" + number + "]";
    }
    
}
