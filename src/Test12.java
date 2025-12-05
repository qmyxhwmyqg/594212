public class Test12 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("线程1: " + i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'J'; c++) {
                    System.out.println("线程2: " + c);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}