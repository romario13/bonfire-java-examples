package examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 */
public class DiskIO {

    private static byte[] fileContent = new byte[1024 * 1024];
    private static Random rnd = new Random();


    public static void firstMethod() {

        try {
            Path path = Files.createTempFile(DiskIO.class.getName(), ".tmp");
            Files.write(path, fileContent);
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void secondMethod() {

        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException ignore) {
            ignore.printStackTrace();
        }

        try {
            Path path = Files.createTempFile(DiskIO.class.getName(), ".tmp");
            Files.write(path, fileContent);
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startThreads(Runnable task, int concurrency) {

        for (int i = 0; i < concurrency; i++) {
            new Thread(task).start();
        }
    }

    public static void main(String[] args) {

        Runnable firstTask = () -> {
            while (true) {
                DiskIO.firstMethod();
            }
        };

        Runnable secondTask = () -> {
            while (true) {
                DiskIO.secondMethod();
            }
        };

        startThreads(firstTask, 5);
        startThreads(secondTask, 5);
    }

}
