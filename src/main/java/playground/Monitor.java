package playground;

public class Monitor {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("__running on JDK24(oracle)__");

        int cpuCoreOver = 4;
        for (int i = 0; i < cpuCoreOver; i++) {
            Thread.startVirtualThread(() -> {
                System.out.println(Thread.currentThread() + ": Before synchronized block");
                synchronized (Monitor.class) {
                    System.out.println(Thread.currentThread() + ": Inside synchronized block");
                }
            });
        }
    }


}