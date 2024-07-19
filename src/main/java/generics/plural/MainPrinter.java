package generics.plural;

import generics.plural.etc.BWCartridge;
import generics.plural.etc.ColorCartridge;
import generics.plural.etc.Printer;

public class MainPrinter {

    public static void main(String[] args) {
        Printer<BWCartridge> prnter = new Printer<BWCartridge>(true, "My PRINTER", new BWCartridge());
        prnter.print(1);
    }
}
