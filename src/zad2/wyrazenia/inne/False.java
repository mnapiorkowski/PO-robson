package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class False extends Wyrażenie {

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        return 0;
    }

    public boolean czySrednik() {
        return true;
    }

    @Override
    public String toString() {
        return "false";
    }
}
