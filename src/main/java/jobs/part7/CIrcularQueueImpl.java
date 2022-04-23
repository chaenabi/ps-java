package jobs.part7;

import java.util.Scanner;

public class CIrcularQueueImpl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int element = -1;

        CircularQueue<Integer> queue = new CircularQueue<>(n);
        while (m-- > 0) {
            int operand = sc.nextInt();
            if (operand == 1) element = sc.nextInt();

            switch (operand) {
                case 1:
                    queue.offer(element);
                    break;
                case 2:
                    queue.poll();
                    break;
                case 3:
                    queue.front();
                    break;
            }
        }
    }



}

class CircularQueue<T> {

    private final T[] array;
    private final int size;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    public void offer(T data) {
        if (array[tail] != null) System.out.println("Overflow");
        else {
            array[tail] = data;
            tail = (tail + 1) % size;
        }
    }

    public void poll() {
        if (array[head] == null) System.out.println("Underflow");
        else {
            array[head] = null;
            head = (head + 1) % size;
        }
    }

    public void front() {
        if (head == tail && array[head] == null) System.out.println("NULL");
        else System.out.println(array[head]);
    }
}