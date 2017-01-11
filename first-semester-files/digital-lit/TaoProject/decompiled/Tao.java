import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

public class Tao
extends Thread {
    private static String errorMaker;

    public static void main(String[] args) {
        Tao phi = new Tao();
        phi.run();
    }

    @Override
    public void run() {
        try {
            TaoCommand console2 = new TaoCommand();
            console2.run();
        }
        catch (Exception console2) {
            // empty catch block
        }
        try {
            System.out.print("Starting Tao Protocol");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.println(".");
        }
        catch (InterruptedException console2) {
            // empty catch block
        }
        try {
            System.out.println("Protocol Version 0.13.41");
            TimeUnit.MILLISECONDS.sleep(900);
        }
        catch (InterruptedException console2) {
            // empty catch block
        }
        try {
            System.out.print("Starting Creative Threads");
            TimeUnit.MILLISECONDS.sleep(700);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(700);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(700);
            System.out.println(".");
            System.out.println("4 Creative Streams Started, Designations:");
            System.out.println("Poe\nFrost\nDickinson\nWhitman");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.println();
            System.out.print("Combining Creative Streams in 3");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print("   2");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print("   1");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println();
            System.out.println();
        }
        catch (InterruptedException console2) {
            // empty catch block
        }
        CreativeStream poe = new CreativeStream("Poe");
        CreativeStream frost = new CreativeStream("Frost");
        CreativeStream dickinson = new CreativeStream("Dickinson");
        CreativeStream whitman = new CreativeStream("Whitman");
        Thread thPoe = new Thread(poe);
        Thread thFrost = new Thread(frost);
        Thread thDickinson = new Thread(dickinson);
        Thread thWhitman = new Thread(whitman);
        thDickinson.start();
        thFrost.start();
        thPoe.start();
        thWhitman.start();
        try {
            thDickinson.join();
            thFrost.join();
            thPoe.join();
            thWhitman.join();
        }
        catch (InterruptedException var9_13) {
            // empty catch block
        }
        try {
            TimeUnit.MILLISECONDS.sleep(1500);
            System.out.println("Combination complete, lines generated: 160");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.print("Determination of Poetic Entropy: ");
            TimeUnit.MILLISECONDS.sleep(900);
            System.out.println("No Noticeable Entropic Increase");
            TimeUnit.MILLISECONDS.sleep(700);
            System.out.println("Success Criteria Met");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("Closing Creative Streams:");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("    Separating Consciousness from Input...");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("    Storing Neural State...");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("    Terminating All Created Conscious Instances...");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("COMPLETE");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Tao Consciousness will now Terminate");
            TimeUnit.MILLISECONDS.sleep(900);
        }
        catch (InterruptedException var9_14) {
            // empty catch block
        }
        for (int i = 0; i < 5; ++i) {
            try {
                errorMaker.length();
                TimeUnit.MILLISECONDS.sleep(400);
                continue;
            }
            catch (InterruptedException var10_17) {
                // empty catch block
            }
        }
    }
}

