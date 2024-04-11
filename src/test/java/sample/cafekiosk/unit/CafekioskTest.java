package sample.cafekiosk.unit;

import org.junit.jupiter.api.Test;
import sample.cafekiosk.unit.bevarage.Americano;
import sample.cafekiosk.unit.bevarage.Latte;

import static org.assertj.core.api.Assertions.assertThat;
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
}