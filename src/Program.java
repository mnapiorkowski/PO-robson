package zad2;

import zad2.wyrazenia.inne.Blok;

public class Program {
    private Blok program;
    private BazaZmiennych bazaZmiennych;

    public Program(Blok blok) {
        program = blok;
        bazaZmiennych = new BazaZmiennych();
    }

    public Blok dajProgram() {
        return program;
    }

    public double wykonaj() {
        return program.dajWynik(bazaZmiennych);
    }

    public String toString(String nazwa) {
        //program.dajWynik();
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("public class ");
        sbuf.append(nazwa);
        sbuf.append(" {\n");
        sbuf.append("public static void main(String args[]) {\n");
        sbuf.append(program.ostatniaToString());
        sbuf.append("}\n}");
        return sbuf.toString();
    }

    @Override
    public String toString() {
        return toString("Program");
    }
}
