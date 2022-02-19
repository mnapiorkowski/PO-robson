package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class While extends Wyrażenie {
    private Wyrażenie warunek;
    private Wyrażenie blok;

    public While(Wyrażenie warunek, Wyrażenie blok) {
        this.warunek = warunek;
        this.blok = blok;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        while (warunek.dajWynik(bazaZmiennych) != 0) {
            blok.dajWynik(bazaZmiennych);
        }
        return 0;
    }

    public boolean czySrednik() {
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("while (");
        sbuf.append(warunek.toString());
        sbuf.append(") {\n");
        sbuf.append(blok.toString());
        sbuf.append("}");
        return sbuf.toString();
    }

    @Override
    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(toString());
        sbuf.append("System.out.println(0);\n");
        return sbuf.toString();
    }
}
