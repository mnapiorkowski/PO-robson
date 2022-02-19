package zad2;

public abstract class Wyrażenie {

    public abstract double dajWynik(BazaZmiennych bazaZmiennych);

    public abstract boolean czySrednik();

    public abstract String toString();

    public String ostatniaToString() {
        StringBuffer sbuf = new StringBuffer();
        sbuf
                .append("System.out.println(")
                .append(toString())
                .append(");\n");
        return sbuf.toString();
    }
}
