package excercises.java.generics.plural;

import excercises.java.generics.plural.etc.BWCartridge;
import excercises.java.generics.plural.etc.Printer;

public class MainPrinter {

    public static void main(String[] args) {
        Printer<BWCartridge> prnter = new Printer<BWCartridge>(true, "My PRINTER", new BWCartridge());
        prnter.print(1);
    }
}
