package thiago.dev.com.java_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thiago.dev.com.java_api.domain.Order;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class OrderController {

    private ArrayList<Order> orders = new ArrayList<>();

    public OrderController(){
        orders.add(new Order(1, "123456"));
        orders.add(new Order(2, "789456"));
    }

    @RequestMapping("/orders")
    public ArrayList<Order> getOrders() {
        return orders;
    }
}
