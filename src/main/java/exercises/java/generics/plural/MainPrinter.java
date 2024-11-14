package exercises.java.generics.plural;

import exercises.java.generics.plural.etc.BWCartridge;
import exercises.java.generics.plural.etc.Printer;

public class MainPrinter {

    public static void main(String[] args) {
        Printer<BWCartridge> prnter = new Printer<BWCartridge>(true, "My PRINTER", new BWCartridge());
        prnter.print(1);
    }
}
