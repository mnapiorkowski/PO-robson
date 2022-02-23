package zad2.wyrazenia.inne;

import zad2.Wyrażenie;
import zad2.BazaZmiennych;

public class Przypisanie extends Wyrażenie {
    private String nazwa;
    private Wyrażenie wartosc;

    public Przypisanie(String nazwa, Wyrażenie wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    public double dajWynik(BazaZmiennych bazaZmiennych) {
        double x = wartosc.dajWynik(bazaZmiennych);
        bazaZmiennych.ustawWartość(nazwa, x);
        return x;
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
        sbuf.append(" = ");
        sbuf.append(wartosc.toString());
        return sbuf.toString();
    }

    @Override
    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf.append(toString());
        sbuf.append(";\n");
        sbuf.append("System.out.println(");
        sbuf.append(nazwa);
        sbuf.append(");\n");
        return sbuf.toString();
    }
}
