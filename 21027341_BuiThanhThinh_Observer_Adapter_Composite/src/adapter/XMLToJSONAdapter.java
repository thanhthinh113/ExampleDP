package adapter;

//Adapter chuyển từ XML sang JSON
public class XMLToJSONAdapter implements DataProcessor {
 private JSONProcessor jsonProcessor;

 public XMLToJSONAdapter(JSONProcessor jsonProcessor) {
     this.jsonProcessor = jsonProcessor;
 }

 @Override
 public void processData(String data) {
     // Chuyển đổi XML sang JSON đơn giản (giả định)
     String jsonData = "{\"data\": \"" + data + "\"}";
     jsonProcessor.processJSON(jsonData);
 }
}
