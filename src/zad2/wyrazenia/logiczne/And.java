package zad2.wyrazenia.logiczne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;
import zad2.wyrazenia.WyrażenieLogiczne;

public class And extends WyrażenieLogiczne {
    private Wyrażenie argument1;
    private Wyrażenie argument2;

    public And(Wyrażenie arg1, Wyrażenie arg2) {
        this.argument1 = arg1;
        this.argument2 = arg2;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        if (argument1.dajWynik(bazaZmiennych) != 0 && argument2.dajWynik(bazaZmiennych) != 0)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf
                .append("(")
                .append(argument1.toString())
                .append(") && (")
                .append(argument2.toString())
                .append(")");
        return sbuf.toString();
    }
}
