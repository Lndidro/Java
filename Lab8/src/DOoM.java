import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOoM {
    static List<ShikiMap> mapList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src\\File.xml"));
        NodeList elements = doc.getDocumentElement().getElementsByTagName("url");
        for (int i = 0; i < elements.getLength(); i++) {
            List<String> shiki = new ArrayList<>();
            NodeList nodeList = elements.item(i).getChildNodes();
            for (int j = 0; j < nodeList.getLength(); j++) {
                if (nodeList.item(j) instanceof Element) {
                    shiki.add(nodeList.item(j).getTextContent());
                    System.out.println(nodeList.item(j).getNodeName() + " " + nodeList.item(j).getTextContent());
                }
            }
            mapList.add(new ShikiMap(shiki.get(0), shiki.get(1), Float.parseFloat(shiki.get(2))));
        }

        for (var s : mapList) {
            System.out.println(s.toString());
        }
    }
}
