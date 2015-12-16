package examples;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 */
public class CPU {
    
    public static void firstMethod(long delay) {
        run(delay);
    }

    public static void secondMethod(long delay) {
        run(delay);
    }

    public static void thirdMethod(long delay) {
        run(delay);
    }

    private static void run(long delay) {
        while (true) {
            try {
                TimeUnit.MICROSECONDS.sleep(delay);
            } catch (InterruptedException ignore) {
            }
        }
    }

    public static void main(String[] args) {

        final Random rnd = new Random();

        new Thread (() -> {CPU.firstMethod(rnd.nextInt(100));}).start();
        new Thread (() -> {CPU.secondMethod(rnd.nextInt(100));}).start();
        new Thread (() -> {CPU.thirdMethod(rnd.nextInt(100));}).start();
    }

}
