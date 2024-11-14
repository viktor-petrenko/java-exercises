package excercises.other.generics.plural;

import excercises.other.generics.plural.etc.BWCartridge;
import excercises.other.generics.plural.etc.Printer;

public class MainPrinter {

    public static void main(String[] args) {
        Printer<BWCartridge> prnter = new Printer<BWCartridge>(true, "My PRINTER", new BWCartridge());
        prnter.print(1);
    }
}
