package observer;

public class Main {
    public static void main(String[] args) {
        // Tạo Subject (Công việc)
        Subject task = new Subject();

        // Tạo Observer (Nhà đầu tư hoặc thành viên nhóm)
        ConcreteObserver member1 = new ConcreteObserver("Alice");
        ConcreteObserver member2 = new ConcreteObserver("Bob");

        // Đăng ký Observer vào Subject
        task.addObserver(member1);
        task.addObserver(member2);

        // Thay đổi trạng thái công việc và thông báo cho các Observer
        task.setState("Task is in progress");
        task.setState("Task is completed");
    }
}

