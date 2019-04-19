package Token;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import org.jdom2.JDOMException;

public class TesCorpus {

    public static void main(String[] args) throws JDOMException, IOException {
        StringTokenizer firstSplit = new StringTokenizer("saya minum obat flu -");
        int limit = firstSplit.countTokens();
        String[] listToken = new String[limit + 10];

        int j = 0;
        while (firstSplit.hasMoreElements()) {
            listToken[j] = firstSplit.nextToken();
            j++;
        }

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File("corpus/db.xml");

        Document document = (Document) builder.build(xmlFile);
        Element rootNode = document.getRootElement();
        List<Element> list = rootNode.getChildren();

        String temporaryToken = "";
        int k = 0;
        while (k < limit) {
            for (Element node : list) {
                String firstWord = node.getName();
                if (listToken[k].equals(firstWord)) {
                    List<Element> childList = node.getChildren();
                    for (Element childNode : childList) {
                        String secondWord = childNode.getName();
                        if (listToken[k + 1].equals(secondWord)) {
                            temporaryToken += listToken[k] + " " + listToken[k + 1] + "|";
                            k += 2;
                            break;
                        }
                    }
                }
            }
            temporaryToken += listToken[k] + "|";
            k++;
        }

        System.out.println(temporaryToken);
        /*
         for (Element node : list) {
         String firstWord = node.getName();
         System.out.println("Parent : " + firstWord);
         System.out.println("Child : ");
         List<Element> childList = node.getChildren();
         for (Element childNode : childList) {
         String secondWord = childNode.getName();
         System.out.println("        - " + secondWord);
         }
         System.out.println();
         }
         */
    }
}
