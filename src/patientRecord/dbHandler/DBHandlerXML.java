package patientRecord.dbHandler;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DBHandlerXML implements IDBHandler {
    private final String filePath = "patient_data.xml";

    @Override
    public void saveData(Map<String, HashMap<String, Object>> dataMap) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Patients");
            document.appendChild(root);

            for (Map.Entry<String, HashMap<String, Object>> entry : dataMap.entrySet()) {
                Element patient = document.createElement("Patient");
                patient.setAttribute("userId", entry.getKey());

                // Recordを追加日付の降順にソートする
                TreeMap<String, Object> sortedRecords = new TreeMap<>(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int recordNumber1 = Integer.parseInt(o1.substring(6));
                        int recordNumber2 = Integer.parseInt(o2.substring(6));
                        return Integer.compare(recordNumber2, recordNumber1); // 降順
                    }
                });
                sortedRecords.putAll(entry.getValue());

                for (Map.Entry<String, Object> dataEntry : sortedRecords.entrySet()) {
                    Element data = document.createElement(dataEntry.getKey());
                    data.appendChild(document.createTextNode(dataEntry.getValue().toString()));
                    patient.appendChild(data);
                }

                root.appendChild(patient);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));

            transformer.transform(domSource, streamResult);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, HashMap<String, Object>> loadData() {
        Map<String, HashMap<String, Object>> dataMap = new HashMap<>();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return dataMap;
            }

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new FileReader(file)));

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Patient");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String userId = element.getAttribute("userId");
                    HashMap<String, Object> data = new HashMap<>();

                    NodeList dataList = element.getChildNodes();
                    for (int j = 0; j < dataList.getLength(); j++) {
                        Node dataNode = dataList.item(j);

                        if (dataNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element dataElement = (Element) dataNode;
                            data.put(dataElement.getTagName(), dataElement.getTextContent());
                        }
                    }

                    dataMap.put(userId, data);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return dataMap;
    }
}
