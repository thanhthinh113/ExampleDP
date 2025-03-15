package composite;

import java.util.ArrayList;
import java.util.List;

// Folder Class
public class Folder implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();  // Danh sách các thư mục con hoặc tập tin

    public Folder(String name) {
        this.name = name;
    }

    // Thêm Component vào thư mục
    public void add(Component component) {
        children.add(component);
    }

    // Xóa Component khỏi thư mục
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Folder: " + name);
        for (Component component : children) {
            component.display();  // Hiển thị các phần tử con trong thư mục
        }
    }
}

