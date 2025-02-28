package playground;

public class Monitor {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("__running on JDK21(azul)__");
        for (int i = 0; i < 1_000_000; i++) {
            Thread.ofVirtual().start(() -> {
                synchronized (lock) {
                    System.out.println("Thread ID: " + Thread.currentThread().threadId());
                }
            });
        }
    }
}