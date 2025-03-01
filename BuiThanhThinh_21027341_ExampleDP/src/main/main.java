package main;

public class main {
    public static void main(String[] args) {
//        ThreadSafeSingleton instance1 = ThreadSafeSingleton.getInstance();
//        ThreadSafeSingleton instance2 = ThreadSafeSingleton.getInstance();
//        
//        System.out.println("Instance 1: " + instance1.hashCode());
//        System.out.println("Instance 2: " + instance2.hashCode());
        
      BillPughSingleton instance1 = BillPughSingleton.getInstance();
      BillPughSingleton instance2 = BillPughSingleton.getInstance();
      
      System.out.println("Instance 1: " + instance1.hashCode());
      System.out.println("Instance 2: " + instance2.hashCode());
        

        
    }
}
