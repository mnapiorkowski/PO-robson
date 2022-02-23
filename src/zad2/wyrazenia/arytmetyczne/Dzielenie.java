package zad2.wyrazenia.arytmetyczne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;
import zad2.wyrazenia.WyrażenieArytmetyczne;

public class Dzielenie extends WyrażenieArytmetyczne {


    public Dzielenie(Wyrażenie arg1, Wyrażenie arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) throws ArithmeticException {
        if (argument2.dajWynik(bazaZmiennych) == 0)
            throw new ArithmeticException("Dzielenie przez zero");
        return argument1.dajWynik(bazaZmiennych) / argument2.dajWynik(bazaZmiennych);
    }

    @Override
    public String toString() {
        return argument1.toString() + " / " + argument2.toString();
    }
}
