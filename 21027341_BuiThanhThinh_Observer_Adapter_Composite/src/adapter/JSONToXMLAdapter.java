package adapter;

//Adapter chuyển từ JSON sang XML
public class JSONToXMLAdapter implements DataProcessor {
 private XMLProcessor xmlProcessor;

 public JSONToXMLAdapter(XMLProcessor xmlProcessor) {
     this.xmlProcessor = xmlProcessor;
 }

 @Override
 public void processData(String data) {
     // Chuyển đổi JSON sang XML đơn giản (giả định)
     String xmlData = "<data>" + data + "</data>";
     xmlProcessor.processXML(xmlData);
 }
}
