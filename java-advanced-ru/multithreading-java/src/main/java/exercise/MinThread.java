package exercise;

public class MinThread extends Thread {
    private int[] array;

    public MinThread(int[] array) {
        super();
        this.array = array;
    }

    public int getMin() {
        return min;
    }

    private int min;
    @Override
    public void run() {
        min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min)
                min = array[i];
        }
    }
}
