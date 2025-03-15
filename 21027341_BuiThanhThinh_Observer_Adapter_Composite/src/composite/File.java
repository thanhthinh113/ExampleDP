package composite;

//File Class
public class File implements Component {
 private String name;
 private String data;  // Dữ liệu của tập tin

 public File(String name, String data) {
     this.name = name;
     this.data = data;
 }

 @Override
 public void display() {
     System.out.println("File: " + name + ", Data: " + data);
 }
}
