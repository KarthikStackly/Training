class RunA extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("running %d from A%n", i);
        }
    }
}

class RunB extends Thread {

    public void run() {
        for (int i = 20; i >= 10; i--) {
            System.out.printf("running %d from B%n", i);
        }
    }
}

class RunC extends Thread {
    public void run() {
        for (int i = -1; i >= -10; i--) {
            System.out.printf("running %d from C%n", i);
        }
    }
}

public class MultiThreadingProg{
    static void main() {

        RunA a = new RunA();
        RunB b = new RunB();
        RunC c = new RunC();

        a.start();
        b.start();
        c.start();
    }
}