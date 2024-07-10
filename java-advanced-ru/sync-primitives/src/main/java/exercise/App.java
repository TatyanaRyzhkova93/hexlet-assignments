package exercise;

class App {

    public static void main(String[] args) throws InterruptedException {
        SafetyList list = new SafetyList();
        ListThread listThread = new ListThread(list);
        ListThread listThread2 = new ListThread(list);
        listThread2.start();
        listThread.start();
        listThread.join();
        listThread2.join();
        System.out.println(list.getSize());
    }
}

