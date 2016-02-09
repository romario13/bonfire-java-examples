package examples;

/**
 */
public class CPU {

    public static final int SIZE = 16 * 1024 * 1024;
    public static final int SQRT_SIZE = (int) Math.sqrt(SIZE);

    public static boolean[] firstMethod() {

        boolean[] s = new boolean[SIZE];

        for (int i = 2; i <= SQRT_SIZE; i++) {
            if (!s[i]) {
                for (int j = i * i; j < SIZE; j += i) {
                    if (!s[j]) {
                        s[j] = true;
                    }
                }
            }

        }

        return s;
    }

    public static boolean[] secondMethod() {
        boolean[] s = new boolean[SIZE];

        for (int i = 2; i <= SQRT_SIZE; i++) {
            if (!s[i]) {
                for (int j = i * i; j < SIZE; j += i) {
                    if (!s[j]) {
                        s[j] = true;
                    }
                }
            }

        }

        return s;
    }

    public static boolean[] thirdMethod() {
        boolean[] s = new boolean[SIZE];

        for (int i = 2; i <= SQRT_SIZE; i++) {
            if (!s[i]) {
                for (int j = i * i; j < SIZE; j += i) {
                    if (!s[j]) {
                        s[j] = true;
                    }
                }
            }

        }

        return s;
    }

    public static void startThreads(Runnable task, int concurrency) {

        for (int i = 0; i < concurrency; i++) {
            new Thread(task).start();
        }
    }

    public static void main(String[] args) {

        Runnable firstTask = () -> {
            while (true) {
                CPU.firstMethod();
            }
        };

        Runnable secondTask = () -> {
            while (true) {
                CPU.secondMethod();
            }
        };

        Runnable thirdTask = () -> {
            while (true) {
                CPU.thirdMethod();
            }
        };

        startThreads(firstTask, 1);
        startThreads(secondTask, 5);
        startThreads(thirdTask, 10);
    }

}
