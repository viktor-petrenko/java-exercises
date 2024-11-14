package exercises.java;

public class NewThread_ExtendThread extends Thread {

    NewThread_ExtendThread() {
        super("Demo поток");
        System.out.println("Child: ");
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child прерван");
        }
        System.out.println("Child завершён");
    }

    static class ExtendedThread {
        public static void main(String args[]) {
            new NewThread_ExtendThread();

            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println("Mainк: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Главный поток прерван");
            }
            System.out.println("Главный поток завершён");
        }
    }

}
