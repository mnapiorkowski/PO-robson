package zad2.wyrazenia.logiczne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;
import zad2.wyrazenia.WyrażenieLogiczne;

public class Not extends WyrażenieLogiczne {
    private Wyrażenie argument;

    public Not(Wyrażenie arg) {
        this.argument = arg;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        if (argument.dajWynik(bazaZmiennych) != 0)
            return 0;
        else
            return 1;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf
                .append("!(")
                .append(argument.toString())
                .append(")");
        return sbuf.toString();
    }
}
