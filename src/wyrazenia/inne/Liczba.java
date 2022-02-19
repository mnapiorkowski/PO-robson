package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class Liczba extends Wyrażenie {
    private double wartosc;

    public Liczba(double wartosc) {
        this.wartosc = wartosc;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        return wartosc;
    }

    public boolean czySrednik() {
        return true;
    }

    @Override
    public String toString() {
        return Double.toString(wartosc);
    }
}
