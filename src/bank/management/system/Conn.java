package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "1258");
            s = c.createStatement();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
