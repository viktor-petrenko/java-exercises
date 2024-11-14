package excercises.java.generics.plural.etc;

public class Printer<T> implements IMachine {
    private String modelNumber;
    private PaperTray paperTray = new PaperTray();
    private Machine machine;
    private T cartridge;

    public Printer(boolean isOn, String modelNumber, T cartridge) {
        machine = new Machine(isOn);
        this.modelNumber = modelNumber;
        this.cartridge = cartridge;
    }

    @Override
    public void TurnOn() {
        System.out.println("Warming up printer");
        machine.TurnOn();
    }

    public void print(int copies) {
        System.out.println(cartridge.toString());
        String onStatue = "";
        if (machine.isOn) {
            onStatue = " is On!";
        } else {
            onStatue = " is Off";
        }

        String textToPrint = modelNumber + onStatue;
        while (copies > 0 && !paperTray.isEmpty()) {
            System.out.println(textToPrint);
            copies--;
            paperTray.usePage();
        }
    }
}
