package exercise;

import java.util.Random;

public class ListThread extends Thread {
    private SafetyList list;
    public ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random rn = new Random();
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(rn.nextInt());
        }
    }
}
