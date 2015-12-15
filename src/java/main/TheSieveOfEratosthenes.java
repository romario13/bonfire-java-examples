/**
 */
public class TheSieveOfEratosthenes {

    public static final int CONCURRENCY = 20;
    public static final int SIZE = 16 * 1024 * 1024;
    public static final int SQRT_SIZE = (int) Math.sqrt(SIZE);

    /**
     * l1-dcache-store-misses
     *
     * @return
     */
    public static boolean[] alwaysWrite() {

        boolean[] s = new boolean[SIZE];

        for (int i = 2; i <= SQRT_SIZE; i++) {
            if (!s[i]) {
                for (int j = i * i; j < SIZE; j += i) {
                    s[j] = true;
                }
            }
        }

        return s;
    }


    public static boolean[] testAndWrite() {

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

    public static void startThreads(Runnable task) {

        for (int i = 0; i < CONCURRENCY; i++) {
            new Thread(task).start();
        }
    }

    public static void main(String[] args) {

        Runnable alwaysWriteTask = () -> {
            while (true) {
                TheSieveOfEratosthenes.alwaysWrite();
            }
        };

        Runnable testAndWrite = () -> {
            while (true) {
                TheSieveOfEratosthenes.testAndWrite();
            }
        };

        switch (args[0]) {
            case "alwaysWrite":
                startThreads(alwaysWriteTask);
                break;
            case "testAndWrite":
                startThreads(testAndWrite);
                break;
            default:
                throw new IllegalArgumentException("alwaysWrite|testAndWrite argument not found");
        }

    }
}
