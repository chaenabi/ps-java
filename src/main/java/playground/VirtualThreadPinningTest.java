package playground;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VirtualThreadPinningTest {
    private static final Object syncLock = new Object();
    private static final Lock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Testing with synchronized block:");
        testWithSynchronizedBlock();

        System.out.println("\nTesting with ReentrantLock:");
        testWithReentrantLock();
    }

    private static void testWithSynchronizedBlock() throws InterruptedException {
        int cpuCoreOver = 4;
        for (int i = 0; i < cpuCoreOver; i++) {
            Thread virtualThread = Thread.ofVirtual().start(() -> {
                synchronized (syncLock) {
                    performBlockingIO();
                }
            });
            virtualThread.join();
        }
    }

    private static void testWithReentrantLock() throws InterruptedException {
        int cpuCoreOver = 4;
        for (int i = 0; i < cpuCoreOver; i++) {
            Thread virtualThread = Thread.ofVirtual().start(() -> {
                reentrantLock.lock();
                try {
                    performBlockingIO();
                } finally {
                    reentrantLock.unlock();
                }
            });
            virtualThread.join();
        }
    }

    private static void performBlockingIO() {
        try {
            // 블로킹 I/O
            System.out.println(Thread.currentThread());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
