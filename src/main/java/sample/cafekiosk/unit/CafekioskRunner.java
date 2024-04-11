package sample.cafekiosk.unit;

import sample.cafekiosk.spring.CafekioskApplication;
import sample.cafekiosk.unit.bevarage.Americano;
import sample.cafekiosk.unit.bevarage.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

public class CafekioskRunner {
    public static void main(String[] args) {
        Cafekiosk cafekiosk = new Cafekiosk();
        cafekiosk.add(new Americano());
        cafekiosk.add(new Latte());
        int totalPrice = cafekiosk.calculateTotalPrice();

        Order order = cafekiosk.createOrder(LocalDateTime.now());
    }
}
