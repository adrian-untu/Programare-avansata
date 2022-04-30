package Lab7.homework;

import static java.lang.Thread.sleep;

public class Timekeeper implements Runnable {
    @Override
    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
