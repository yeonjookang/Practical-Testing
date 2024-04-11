package sample.cafekiosk.unit;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import sample.cafekiosk.unit.bevarage.Americano;
import sample.cafekiosk.unit.bevarage.Beverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
public class Cafekiosk {
    private final List<Beverage> beverages = new ArrayList<>();

    public void add(Beverage beverage) {
        beverages.add(beverage);
        System.out.println(">>> "+beverage.getName()+" 추가");
    }

    public void remove(Beverage beverage) {
        beverages.remove(beverage);
        System.out.println(">>> "+beverage.getName()+" 삭제");
    }

    public void clear(){
        beverages.clear();
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for(Beverage beverage : beverages)
            totalPrice+= beverage.getPrice();
        System.out.println("총 주문가격: "+totalPrice+"원");
        return totalPrice;
    }

    public Order createOrder(){
        return new Order(LocalDateTime.now(), beverages);
    }
}
