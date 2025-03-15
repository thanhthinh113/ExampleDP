package observer;

//ConcreteObserver Class
public class ConcreteObserver implements Observer {
 private String name;

 public ConcreteObserver(String name) {
     this.name = name;
 }

 // Cập nhật trạng thái khi nhận được thông báo từ Subject
 @Override
 public void update(String state) {
     System.out.println(name + " received update: Task status changed to \"" + state + "\"");
 }
}
