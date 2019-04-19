package Prototype;

import Koneksi.KoneksiDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PhraseLibraries {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    private StringTokenizer firstSplit;
    private int limit;
    private String[] listToken;
    private LinkedList<String> linkedList = new LinkedList<String>();

    public String getFirstSplit(String compareObject) throws SQLException {
        con = new KoneksiDb().getConnect();
        this.firstSplit = new StringTokenizer(compareObject);
        this.limit = firstSplit.countTokens();
        this.listToken = new String[+10];
        int j = 0;
        while (firstSplit.hasMoreElements()) {
            listToken[j] = firstSplit.nextToken();
            j++;
        }

        String sql = "select * from kamus_tbl order by data asc";
        st = con.createStatement();
        rs = st.executeQuery(sql);
        while (rs.next()) {
            linkedList.add(rs.getString("data"));
        }

        String temporaryToken = "";
        int x = 0;
        while (x < limit) {
            String compareToken = listToken[x] + " " + listToken[x + 1];
            for (String compareValue : linkedList) {
                if (compareToken.equals(compareValue)) {
                    temporaryToken += compareToken + "|";
                    x += 2;
                    System.out.println("now program in if");
                    break;
                } else if (compareToken.equals("ber"+compareValue) || compareToken.equals("me"+compareValue) ||
                        compareToken.equals("mem"+compareValue) || compareToken.equals(compareValue+"nya") ||
                        compareToken.equals(compareValue+".") || compareToken.equals(compareValue+",") ||
                        compareToken.equals("."+compareValue)) {
                    temporaryToken += compareToken + "|";
                    x += 2;
                    System.out.println("now program in if");
                    break;
                }
            }
            temporaryToken += listToken[x] + "|";
            x++;
        }
        return temporaryToken;
    }
}