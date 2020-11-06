package baekjoon;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The Josephus problem The problem is named after Flavius Josephus, a Jewish
 * historian living in the 1st century. A less bloody version of the problem can
 * be described as follows: Given a group of n man arranged in a circle under
 * the edict that every mth man will be stand off the circle until no one stand
 * off, find all the position J(n, m) in which you should stand in order to
 * remain in the circle.
 *
 * @author jxue
 *
 */
public class Josephus {
    /**
     * @param args
     *   args[0] N value, int, total number of players
     *   args[1] M value, int, every Mth man will be stand off
     */
    public static void main(String[] args) {

        // / get arguments
        int N = Integer.valueOf(args[0]);
        int M = Integer.valueOf(args[1]);
        CircularArrayQueue<Integer> circle = new CircularArrayQueue<Integer>();
        // / initialize the circle
        for (int i = 1; i <= N; ++i) {
            circle.enqueue(i);
        }
        // / eliminating from the circle
        while (circle.size() >= M) {
            // / push the skipped man to the end of queue
            for (int i = 1; i <= M - 1; ++i)
                circle.enqueue(circle.dequeue());
            // / eliminate every Mth man
            Integer r = circle.dequeue();
            System.out.println("Eliminated #" + r);
        }
        System.out.println("Men # remains in the circle:");
        System.out.println(circle);
    }

}

/**
 * CircularArrayQueue represents an array implementation of a queue in
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 *
 * @author Dr. Lewis
 * @author Dr. DePasqaule
 * @author Dr. Chase
 * @version 1.0 08/12/08
 */

class CircularArrayQueue<T> {
    private final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty queue using the specified capacity.
     *
     * @param initialCapacity
     *            the integer representation of the initial size of the circular
     *            array queue
     */
    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = ((T[]) (new Object[initialCapacity]));
    }

    /**
     * Adds the specified element to the rear of this queue, expanding the
     * capacity of the queue array if necessary.
     *
     * @param element
     *            the element to add to the rear of the queue
     */
    public void enqueue(T element) {
        if (size() == queue.length)
            expandCapacity();

        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the reference to the element at the front of the queue that was
     *         removed
     * @throws EmptyCollectionException
     *             if an empty collections exception occurs
     */
    public T dequeue() {
        if (isEmpty())
            throw new RuntimeException("empty queue");

        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;

        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the front of this queue. The
     * element is not removed from the queue. Throws an EmptyCollectionException
     * if the queue is empty.
     *
     * @return a reference to the first element in the queue
     * @throws EmptyCollectionException
     *             if an empty collections exception occurs
     */
    public T first() {
        if (isEmpty())
            throw new RuntimeException("empty queue");

        return queue[front];
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     *
     * @return returns true if this queue is empty and false if otherwise
     */
    public boolean isEmpty() {
        return (front == rear);
    }

    /**
     * Returns the number of elements currently in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    public int size() {
        int size = rear - front;
        if (size < 0)
            size += queue.length;
        return size;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    public String toString() {
        String result = "";
        int scan = front;

        while (scan != rear) {
            result += queue[scan].toString() + "\n";
            scan = (scan+1) % queue.length;
        }

        return result;
    }

    /**
     * Creates a new array to store the contents of this queue with twice the
     * capacity of the old one.
     */
    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = count;
        queue = larger;
    }
}