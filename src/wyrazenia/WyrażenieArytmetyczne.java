package zad2.wyrazenia;

import zad2.Wyrażenie;

public abstract class WyrażenieArytmetyczne extends Wyrażenie {
    protected Wyrażenie argument1;
    protected Wyrażenie argument2;

    public boolean czySrednik() {
        return true;
    }
}
