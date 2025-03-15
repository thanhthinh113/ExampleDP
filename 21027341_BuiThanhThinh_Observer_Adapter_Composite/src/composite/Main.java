package composite;

public class Main {
    public static void main(String[] args) {
        // Tạo thư mục gốc
        Folder root = new Folder("Root");

        // Tạo thư mục con và thêm vào thư mục gốc
        Folder subFolder1 = new Folder("SubFolder1");
        Folder subFolder2 = new Folder("SubFolder2");
        root.add(subFolder1);
        root.add(subFolder2);

        // Tạo tập tin và thêm vào các thư mục
        File file1 = new File("File1.txt", "This is file 1.");
        File file2 = new File("File2.txt", "This is file 2.");
        subFolder1.add(file1);
        subFolder1.add(file2);
        subFolder2.add(file2);

        // Hiển thị thông tin thư mục và tập tin
        root.display();
    }
}

