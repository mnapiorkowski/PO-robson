package zad2.wyrazenia.porownujace;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;
import zad2.wyrazenia.WyrażeniaPorównujące;

public class Równe extends WyrażeniaPorównujące {

    public Równe(Wyrażenie arg1, Wyrażenie arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        if (argument1.dajWynik(bazaZmiennych) == argument2.dajWynik(bazaZmiennych))
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return argument1.toString() + " == " + argument2.toString();
    }
}
