package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class Zmienna extends Wyrażenie {
    private String nazwa;

    public Zmienna(String nazwa) {
        this.nazwa = nazwa;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        Double wartość = bazaZmiennych.dajWartość(nazwa);
        if (wartość == null)
            return 0;
        else
            return wartość;
    }

    public boolean czySrednik() {
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        if (!BazaZmiennych.zainicjowana(nazwa)) {
            sbuf.append("double ");
        }
        sbuf.append(nazwa);
        return sbuf.toString();
    }

    @Override
    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("System.out.println(");
        if (!BazaZmiennych.zainicjowana(nazwa))
            sbuf.append("0");
        else
            sbuf.append(nazwa);
        sbuf.append(");\n");
        return sbuf.toString();
    }
}
