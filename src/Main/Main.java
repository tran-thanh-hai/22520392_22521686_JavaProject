/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 *
 * @author rubik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SQLServerDataSource ds = new SQLServerDataSource();
        
        ds.setUser("sa");
        ds.setPassword("22520392_Hai");
        ds.setServerName("UMI-COMPUTER-42\\SQLEXPRESS");
        ds.setPortNumber(Integer.parseInt("1433"));
        ds.setDatabaseName("QLGV");
        
        try {
            java.sql.Connection con = ds.getConnection();
            System.out.println("Ket noi thanh cong");
            System.out.println(con);
        } catch (SQLServerException ex) {
            System.out.println("Loi ket noi: " + ex.getMessage());
        }

        
        
    }
    
}
