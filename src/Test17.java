import java.util.LinkedList;
import java.util.Queue;

public class Test17 {
    private static final int CAPACITY = 5;
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (queue) {
                    while (queue.size() == CAPACITY) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(i);
                    System.out.println("生产: " + i);
                    queue.notifyAll();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = queue.poll();
                    System.out.println("消费: " + value);
                    queue.notifyAll();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}