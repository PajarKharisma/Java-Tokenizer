package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDb {
    public Connection getConnect() throws SQLException {
        Connection koneksi = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_kamus", "root", "");
            System.out.println("Koneksi Berhasil");
        }
        catch(ClassNotFoundException er){
            System.out.println("#Error 1 : " + er.getMessage());
            System.exit(0);
        }
        catch(SQLException er){
            System.out.println("#Error 2 : " + er.getMessage());
            System.exit(0);
        }
        return koneksi;
    }
}
