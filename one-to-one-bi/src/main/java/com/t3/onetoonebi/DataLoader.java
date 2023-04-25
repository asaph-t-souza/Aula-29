package com.t3.onetoonebi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.t3.onetoonebi.entity.Address;
import com.t3.onetoonebi.entity.Order;
import com.t3.onetoonebi.repository.AddressRepository;
import com.t3.onetoonebi.repository.OrderRepository;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private OrderRepository orderRep;

    @Autowired
    private AddressRepository addressRep;

    @Override
    public void run(String... args) throws Exception {
        createOrder("ADF45TY", 50, 400, "A CAMINHO", "56423-895", "Rua dos Bobos", 0);

        fetchOrder(1);
    }

    void createOrder(String orderCode, int weight, int price, String status, String cep, String street, int number ){
        //Criamos um objeto Order e setamos os atributos
        Order order = new Order();
        order.setOrderCode(orderCode);
        order.setWeight(weight);
        order.setPrice(price);
        order.setStatus(status);

        //Criamos um objeto Address e setamos os atributos
        Address address = new Address();
        address.setCep(cep);
        address.setStreet(street);
        address.setNumber(number);

        //Setamos a relação em ambos objetos
        order.setAddressId(address);
        address.setOrderId(order);

        orderRep.save(order);
    }

    void fetchAddress(int id){
        Address address = addressRep.findById(id).get();
        System.out.println("Address");
        System.out.println(address.toString());
        System.out.println("Order");
        System.out.println(address.getOrderId().toString());
    }

    void fetchOrder(int id){
        Order order = orderRep.findById(id).get();
        System.out.println("Order");
        System.out.println(order.toString());
        System.out.println("Address");
        System.out.println(order.getAddressId().toString());
    }   
    
}
