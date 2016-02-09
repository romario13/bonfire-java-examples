package examples;

/**
 */
public class Mem {

    public static final int SIZE = 16 * 1024 * 1024;

//    public static final BlockingQueue<int[]> queue = new SynchronousQueue<int[]>();

    public static int[] firstMethod() {
        int[] array = new int[SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        return array;
    }

    public static int [] secondMethod() {
        int[] array = new int[SIZE/10];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        return array;
    }

    public static void startThreads(Runnable task, int concurrency) {

        for (int i = 0; i < concurrency; i++) {
            new Thread(task).start();
        }
    }

    public static void main(String[] args) {

        Runnable firstTask = () -> {
            while (true) {
                Mem.firstMethod();
                Mem.secondMethod();
            }
        };

//        Runnable secondTask = () -> {
//            while (true) {
//                try {
//                    queue.take();
//                } catch (InterruptedException ignore) {
//                    ignore.printStackTrace();
//                }
//            }
//        };

        startThreads(firstTask, 5);
//        startThreads(secondTask, 5);
    }

}
