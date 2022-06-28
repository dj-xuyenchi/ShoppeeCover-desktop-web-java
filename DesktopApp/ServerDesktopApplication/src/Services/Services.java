/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ClassLib.ImageFromSql;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Services implements ServiceDAO {
    
    private ServerSocket ss;
    private Socket soc;
    private ObjectOutputStream oos;
    private int port;
    private String connectionUrl;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private List<ImageFromSql> listPackage1;
    
    public Services(int port) {
        this.port = port;
    }
    
    @Override
    public void openSql() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://PC\\SQLEXPRESS:1433;databaseName=SHOPOFQA;encrypt=true;trustServerCertificate=true;";
            con = DriverManager.getConnection(connectionUrl, "sa", "1231234");
            st = con.createStatement();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @Override
    public void openServer() {
        try {
            ss = new ServerSocket(port);
            System.out.println("Port: " + port);
            System.out.println("Listenning.....");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void acceptClient() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        soc = ss.accept();
                        System.out.println("Accept...");
                        System.out.println("Connected...");
                        oos = new ObjectOutputStream(soc.getOutputStream());
                        wrapDataPackage1();
                        oos.writeObject(listPackage1);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
    
    @Override
    public void wrapDataPackage1() {
        listPackage1 = new ArrayList<>();
        openSql();
        String query1 = "Select imgname,imgdata from SERVERIMG order by countid asc";
        try {
            rs = st.executeQuery(query1);
            while (rs.next()) {
                String imgName = rs.getString(1);
                byte[] imgData = rs.getBytes(2);
                listPackage1.add(new ImageFromSql(imgName, imgData));
            }
            closeSql();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void closeSql() {
        try {
            rs.close();
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void closeServer() {
        try {
            oos.close();
            soc.close();
            ss.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
