package adapter;

public class Main {
    public static void main(String[] args) {
        // Sử dụng Adapter để xử lý dữ liệu JSON hoặc XML
        JSONProcessor jsonProcessor = new JSONProcessor();
        XMLProcessor xmlProcessor = new XMLProcessor();

        // Chuyển từ XML sang JSON
        DataProcessor xmlToJsonAdapter = new XMLToJSONAdapter(jsonProcessor);
        xmlToJsonAdapter.processData("<data>XML Content</data>");

        // Chuyển từ JSON sang XML
        DataProcessor jsonToXmlAdapter = new JSONToXMLAdapter(xmlProcessor);
        jsonToXmlAdapter.processData("{\"data\": \"JSON Content\"}");
    }
}
