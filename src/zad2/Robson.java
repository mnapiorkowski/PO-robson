/*
 * PO 2021
 *
 * zad. 2 - Robson
 *
 * Michał Napiórkowski
 */

package zad2;

import zad2.wyrazenia.arytmetyczne.*;
import zad2.wyrazenia.logiczne.*;
import zad2.wyrazenia.porownujace.*;
import zad2.wyrazenia.inne.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

public class Robson {
    public static class NieprawidlowyProgram extends Exception {
        public NieprawidlowyProgram(String wiadomość) {
            super(wiadomość);
        }
    }

    public static class BladWykonania extends Exception {
        public BladWykonania(String wiadomość) {
            super(wiadomość);
        }
    }

    private static Program program;
    private static Moshi moshi;

    public Robson() {
        moshi = new Moshi.Builder()
                .add(
                        PolymorphicJsonAdapterFactory.of(Wyrażenie.class, "typ")
                                .withSubtype(Blok.class, "Blok")
                                .withSubtype(If.class, "If")
                                .withSubtype(While.class, "While")
                                .withSubtype(Przypisanie.class, "Przypisanie")
                                .withSubtype(Plus.class, "Plus")
                                .withSubtype(Minus.class, "Minus")
                                .withSubtype(Razy.class, "Razy")
                                .withSubtype(Dzielenie.class, "Dzielenie")
                                .withSubtype(And.class, "And")
                                .withSubtype(Or.class, "Or")
                                .withSubtype(Not.class, "Not")
                                .withSubtype(Mniejsze.class, "<")
                                .withSubtype(MniejszeRówne.class, "<=")
                                .withSubtype(Większe.class, ">")
                                .withSubtype(WiększeRówne.class, ">=")
                                .withSubtype(Równe.class, "==")
                                .withSubtype(Liczba.class, "Liczba")
                                .withSubtype(Zmienna.class, "Zmienna")
                                .withSubtype(True.class, "True")
                                .withSubtype(False.class, "False")
                    )
                    .build();
    }

    public Program dajProgram() {
        return program;
    }

    public void fromJSON(String filename) throws NieprawidlowyProgram {
        JsonAdapter<Blok> jsonAdapter = moshi.adapter(Blok.class);
        try {
            String json = Files.readString(Paths.get(filename));
            program = new Program(jsonAdapter.fromJson(json));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new NieprawidlowyProgram(e.getMessage());
        }
    }

    public void toJSON(String filename) {
        JsonAdapter<Blok> jsonAdapter = moshi.adapter(Blok.class);
        String json = jsonAdapter.indent(" ").toJson(program.dajProgram());
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toJava(String filename) {
        try {
            Path path = Paths.get(filename);
            String nazwa = path.getFileName().toString();
            nazwa = nazwa.replaceFirst("[.][^.]+$", "");

            // teraz nazwa to czysta nazwa pliku - bez ścieżki i rozszerzenia
            System.out.println(program.toString(nazwa));
            FileWriter writer = new FileWriter(filename);
            String formatted = new Formatter().formatSource(program.toString(nazwa));
            writer.write(formatted);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FormatterException e) {
            throw new RuntimeException("Błąd formatowania pliku .java", e);
        }
    }

    public double wykonaj() throws BladWykonania {
        try {
            return program.wykonaj();
        } catch (Exception e) {
            throw new BladWykonania(e.getMessage());
        }
    }
}
