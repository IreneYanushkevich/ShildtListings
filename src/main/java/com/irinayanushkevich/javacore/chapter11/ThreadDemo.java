package main.java.com.irinayanushkevich.javacore.chapter11;

class NewThread implements Runnable {

    Thread t;

    NewThread() {
        t = new Thread(this, "Demo thread");
        System.out.println("Child thread created: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child thread is interrupted");
        }
        System.out.println("Child thread is completed");
    }
}

class ThreadDemo {

    public static void main(String[] args) {

        new NewThread();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        System.out.println("Main thread is completed");
    }
}
