package main;

import factory.Computer;
import factory.PC;
import factory.Server;

public class main {
    public static void main(String[] args) {
//        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
//        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
//        
//        System.out.println("Instance 1: " + instance1.hashCode());
//        System.out.println("Instance 2: " + instance2.hashCode());
        
//      BillPughSingleton instance1 = BillPughSingleton.getInstance();
//      BillPughSingleton instance2 = BillPughSingleton.getInstance();
//      
//      System.out.println("Instance 1: " + instance1.hashCode());
//      System.out.println("Instance 2: " + instance2.hashCode());
        
//      LazyInitializedSingleton instance1 = LazyInitializedSingleton.getInstance();
//      LazyInitializedSingleton instance2 = LazyInitializedSingleton.getInstance();
//
//      // In ra mã hash của hai đối tượng, nếu giống nhau thì chắc chắn chỉ có một thể hiện.
//      System.out.println("Instance 1: " + instance1.hashCode());
//      System.out.println("Instance 2: " + instance2.hashCode());
//    	StaticBlockSingleton instance1 = StaticBlockSingleton.getInstance();
//    	StaticBlockSingleton instance2 = StaticBlockSingleton.getInstance();
//
//        // In ra mã hash của hai đối tượng, nếu giống nhau thì chắc chắn chỉ có một thể hiện.
//        System.out.println("Instance 1: " + instance1.hashCode());
//        System.out.println("Instance 2: " + instance2.hashCode());
//        
     // Tạo hai luồng để kiểm tra
        Thread thread1 = new Thread(() -> {
            ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
            System.out.println("Thread 1: " + instance1.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
            System.out.println("Thread 2: " + instance2.hashCode());
        });

        // Khởi động các luồng
        thread1.start();
        thread2.start();

        // Chờ cho các luồng kết thúc
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kiểm tra lại trong main thread
        ThreadSafeSingleton mainInstance = ThreadSafeSingleton.getInstance();
        System.out.println("Main Thread: " + mainInstance.hashCode());
    }
    
}
