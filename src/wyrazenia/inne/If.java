package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class If extends Wyrażenie {
    private Wyrażenie warunek;
    private Wyrażenie blok_prawda;
    private Wyrażenie blok_falsz;

    public If(Wyrażenie warunek, Wyrażenie blok_prawda, Wyrażenie blok_falsz) {
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        if (warunek.dajWynik(bazaZmiennych) == 0) {
            if (blok_falsz != null)
                return blok_falsz.dajWynik(bazaZmiennych);
            else
                return 0;
        } else
            return blok_prawda.dajWynik(bazaZmiennych);
    }

    public boolean czySrednik() {
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("if (");
        sbuf.append(warunek.toString());
        sbuf.append(") {\n");
        sbuf.append(blok_prawda.toString());
        sbuf.append("}");
        if (blok_falsz != null) {
            sbuf.append(" else {\n");
            sbuf.append(blok_falsz.toString());
            sbuf.append("}");
        }
        return sbuf.toString();
    }

    @Override
    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("if (");
        sbuf.append(warunek.toString());
        sbuf.append(") {\n");
        sbuf.append(blok_prawda.ostatniaToString());
        sbuf.append("}");
        if (blok_falsz != null) {
            sbuf.append(" else {\n");
            sbuf.append(blok_falsz.ostatniaToString());
            sbuf.append("}");
        }
        return sbuf.toString();
    }
}
