package zad2;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RobsonTest {
    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test() {
        Robson robson = new Robson();
        String filename1 = "test/euklides.json";
        String filename2 = "test/Euklides.java";
        String filename3 = "test/euklides_toJSON.json";

        try {
            robson.fromJSON(filename1);
            robson.toJava(filename2);
            robson.toJSON(filename3);
            assertEquals(42.0, robson.wykonaj(), 0.0);

            Robson robson2 = new Robson();
            robson2.fromJSON(filename3);
            assertEquals(robson.dajProgram(), robson2.dajProgram());

        } catch (Robson.NieprawidlowyProgram e) {
            throw new RuntimeException("Nieprawidłowy program", e);
        } catch (Robson.BladWykonania e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
