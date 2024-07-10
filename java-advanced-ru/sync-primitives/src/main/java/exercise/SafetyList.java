package exercise;

class SafetyList {
    private int[] array = new int[10];
    private int size = 0;
    public synchronized void add(int el) {
        if(array.length >= size + 1) {
            array[size] = el;
            size++;
            return;
        }
        int newCapacity = (array.length * 3) / 2 + 1;
        var elementData = new int[newCapacity];
        System.arraycopy(array, 0, elementData, 0, size);
        array = elementData;
        add(el);
    }
    public int get(int index) {
        return array[index];
    }
    public int getSize() {
        return size;
    }
}
