package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class Blok extends Wyrażenie {
    private Wyrażenie[] instrukcje;

    public Blok() {
        this.instrukcje = null;
    }

    public Blok(Wyrażenie[] instrukcje) {
        this.instrukcje = new Wyrażenie[instrukcje.length];
        System.arraycopy(instrukcje, 0, this.instrukcje, 0, instrukcje.length);
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        if (instrukcje.length == 0)
            return 0;
        else {
            for (int i = 0; i < instrukcje.length - 1; i++) {
                instrukcje[i].dajWynik(bazaZmiennych);
            }
            return instrukcje[instrukcje.length - 1].dajWynik(bazaZmiennych);
        }
    }

    public boolean czySrednik() {
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < instrukcje.length; i++) {
            boolean czySrednik = instrukcje[i].czySrednik();
            sbuf.append(instrukcje[i].toString());
            if (czySrednik)
                sbuf.append(";");

            sbuf.append("\n");
        }
        return sbuf.toString();
    }

    @Override
    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        int ileInstrukcji = instrukcje.length;
        for (int i = 0; i < ileInstrukcji - 1; i++) {
            boolean czySrednik = instrukcje[i].czySrednik();
            sbuf.append(instrukcje[i].toString());
            if (czySrednik)
                sbuf.append(";");
            sbuf.append("\n");
        }
        if (ileInstrukcji > 0) {
            sbuf.append(instrukcje[ileInstrukcji - 1].ostatniaToString());
        }
        return sbuf.toString();
    }
}
