package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.bevarage.Americano;
import sample.cafekiosk.unit.bevarage.Latte;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CafekioskTest {

    @Test
    void add() {
        Cafekiosk cafekiosk = new Cafekiosk();
        cafekiosk.add(new Americano());

        assertThat(cafekiosk.getBeverages()).hasSize(1);
        assertThat(cafekiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void addSeveralBeverages() {
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano,2);

        assertThat(cafekiosk.getBeverages()).hasSize(2);
        assertThat(cafekiosk.getBeverages().get(0)).isEqualTo(americano);
        assertThat(cafekiosk.getBeverages().get(1)).isEqualTo(americano);
    }

    @Test
    void addZeroBeverages() {
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        assertThatThrownBy(()->cafekiosk.add(americano,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.");
    }

    @Test
    void remove() {
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);
        assertThat(cafekiosk.getBeverages()).hasSize(1);

        cafekiosk.remove(americano);
        assertThat(cafekiosk.getBeverages()).isEmpty();
    }

    @Test
    void clear() {
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();
        Latte latte = new Latte();

        cafekiosk.add(americano);
        cafekiosk.add(latte);
        assertThat(cafekiosk.getBeverages()).hasSize(2);

        cafekiosk.clear();
        assertThat(cafekiosk.getBeverages()).isEmpty();
    }

    @Test
    void createOrder(){
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);

        Order order = cafekiosk.createOrder(LocalDateTime.of(2024,4,11,10,0));

        assertThat(order.getBeverages()).hasSize(1);
        assertThat(order.getBeverages().get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void createOrderOutSideOpenTime(){
        Cafekiosk cafekiosk = new Cafekiosk();
        Americano americano = new Americano();

        cafekiosk.add(americano);

        assertThatThrownBy(()->cafekiosk.createOrder(LocalDateTime.of(2024,4,11,9,59)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("주문 시간이 아닙니다. 관리자에게 문의하세요.");
    }
}