package Final;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;
import org.jdom2.JDOMException;

public class Corpus {

    private StringTokenizer firstSplit;
    private String[] listToken;
    private int limit;

    public String getFirstSplit(String compareObject) throws JDOMException, IOException {
        String lowCase = compareObject.toLowerCase() + " -";
        String character = " ";
        firstSplit = new StringTokenizer(lowCase,character);
        limit = firstSplit.countTokens();
        listToken = new String[limit + 10];
        
        int j = 0;
        while (firstSplit.hasMoreElements()) { //proses pemisahan kalimat berdasarkan spasi dan memasukannya ke dalam array listToken
            listToken[j] = firstSplit.nextToken();
            j++;
        }

        SAXBuilder builder = new SAXBuilder(); //instansiasi Class untuk menggunakan database xml
        File xmlFile = new File("src/Final/corpus.xml"); //proses pengambilan database xml

        Document document = (Document) builder.build(xmlFile); //memasukan database xml ke dalam objek document
        Element rootNode = document.getRootElement(); //instansiasi rootNode dan memasukan root database ke dalamnya
        List<Element> list = rootNode.getChildren(); //memasukan kata di tingkat pertama ke dalam list

        String temporaryToken = ""; //deklarasi variable tempat menampung kalimat kedua yang sudah dibagi frasanya
        int i = 0;
        while (i < limit) {
            boolean isSecondWord = true;
            boolean isThirdWord = true;
            for (Element node : list) { //instansiasi objek node dan memasukan daftar kata tingkat pertama ke dalam objek node
                String firstWord = node.getName(); //deklarasi variable firsWord dan memasukan kata tingkat pertama ke dalam firstWord
                if (listToken[i].startsWith(firstWord) || listToken[i].endsWith(firstWord)) { //proses membandingkan kata dalam array listToken dengan setiap kata di tingkat pertama
                    List<Element> childList = node.getChildren(); //memasukan kata di tingkat kedua ke dalam childList
                    for (Element childNode : childList) { //instansiasi objek childNode dan memasukan daftar kata tingkat kedua ke dalam objek node
                        String secondWord = childNode.getName(); //deklarasi variable secondWord dan memasukan kata tingkat kedua ke dalam secondWord
                        if (listToken[i + 1].startsWith(secondWord) || listToken[i + 1].endsWith(secondWord)) { //proses membandingkan satu kata setelah kata dalam array listToken dengan setiap kata di tingkat kedua
                            List<Element> secondChildList = childNode.getChildren(); //memasukan kata di tingkat ketiga ke dalam secondChildList
                            for (Element secondChildNode : secondChildList) { //instansiasi objek secondChildNode dan memasukan daftar kata tingkat ketiga ke dalam objek secondChildNode
                                String thirdWord = secondChildNode.getName(); //deklarasi variable thirdWord dan memasukan kata tingkat katiga ke dalam thirdWord
                                if (listToken[i + 2].startsWith(thirdWord) || listToken[i + 2].endsWith(thirdWord)) { //proses membandingkan dua kata setelah kata dalam array listToken dengan setiap kata di tingkat ketiga
                                    List<Element> thirdChildList = secondChildNode.getChildren();
                                    for (Element thirdChildNode : thirdChildList) {
                                        String fourthWord = thirdChildNode.getName();
                                        System.out.println(fourthWord);
                                        if (listToken[i + 3].startsWith(fourthWord) || listToken[i + 4].endsWith(fourthWord)) {
                                            temporaryToken += listToken[i] + " " + listToken[i + 1] + " " + listToken[i + 2] + " " + listToken[i + 3] + "|";
                                            i += 4;
                                            isSecondWord = false;
                                            isThirdWord = false;
                                            break;
                                        }
                                    }
                                    if (!isThirdWord) {
                                        break;
                                    } else {
                                        temporaryToken += listToken[i] + " " + listToken[i + 1] + " " + listToken[i + 2] + "|";
                                        i += 3;
                                        isSecondWord = false;
                                        break;
                                    }
                                }
                            }
                            if (!isSecondWord) {
                                break;
                            } else {
                                temporaryToken += listToken[i] + " " + listToken[i + 1] + "|";
                                i += 2;
                                break;
                            }
                        }
                    }
                }
            }
            temporaryToken += listToken[i] + "|";
            i++;
        }
        return temporaryToken;
    }
}