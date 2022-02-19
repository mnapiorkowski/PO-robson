package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class True extends Wyrażenie {

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        return 1;
    }

    public boolean czySrednik() {
        return true;
    }

    @Override
    public String toString() {
        return "true";
    }
}
