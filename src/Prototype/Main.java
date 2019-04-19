package Prototype;

import Koneksi.KoneksiDb;
import Token.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        Connection con = new KoneksiDb().getConnect();
        Statement st;
        ResultSet rs;
        PreparedStatement ps;
        
        StringTokenizer firstSplit = new StringTokenizer("April adalah belahan jiwa Buyung");
        int limit = firstSplit.countTokens();
        String[] listToken = new String[limit + 10];
        int j = 0;
        
        while(firstSplit.hasMoreElements()){
            listToken[j] = firstSplit.nextToken();
            j++;
        }
        
        String temporaryToken = "";
        int x = 0;
        while(x<limit){
            String compareToken = listToken[x] + " " +listToken[x+1];
            String sql = "select * from kamus_tbl where data='" + compareToken + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()){
                temporaryToken += compareToken + "|";
                x+=2;
            }  
            else{
                temporaryToken += listToken[x] + "|";
                x++;
            }
        }
        
        StringTokenizer secondSplit = new StringTokenizer(temporaryToken,"|");
        while(secondSplit.hasMoreElements()){
            System.out.println(secondSplit.nextToken());
        }
    }
}