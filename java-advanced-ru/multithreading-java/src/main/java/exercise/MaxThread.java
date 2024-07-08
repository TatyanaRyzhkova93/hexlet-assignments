package exercise;

public class MaxThread extends Thread {
    private int[] array;

    public MaxThread(int[] array) {
        super();
        this.array = array;
    }

    public int getMax() {
        return max;
    }

    private int max;
    @Override
    public void run() {
        max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] >= max)
                max = array[i];
        }
    }
}
