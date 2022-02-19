package zad2;

import java.util.HashMap;
import java.util.HashSet;

public class BazaZmiennych {
    private HashMap<String, Double> zmienne;
    private static HashSet<String> nazwyZmiennych;

    public BazaZmiennych() {
        zmienne = new HashMap<>();
        nazwyZmiennych = new HashSet<>();
    }

    public Double dajWartość(String nazwa) {
        return zmienne.get(nazwa);
    }

    public void ustawWartość(String nazwa, double wartosc) {
        zmienne.put(nazwa, wartosc);
    }

    public static boolean zainicjowana(String nazwa) {
        return !nazwyZmiennych.add(nazwa);
    }
}
