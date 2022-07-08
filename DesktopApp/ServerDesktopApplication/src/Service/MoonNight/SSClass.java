/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.MoonNight;

import ModelLibraries.Account;
import ModelLibraries.ImageFromSql;
import Service.SMI;
import Service.SMI;
import java.io.DataInputStream;
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
 * Server Services Class
 *
 * @author PC
 */
public class SSClass implements SMI {

    private ServerSocket ss;
    private Socket soc;
    private ObjectOutputStream oos;
    private int port;
    private String connectionUrl;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private List<ImageFromSql> listPackage;
    private DataInputStream dis;

    public SSClass(int port) {
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
                        dis = new DataInputStream(soc.getInputStream());
                        oos = new ObjectOutputStream(soc.getOutputStream());
                        int order = dis.readInt();
                        switch (order) {
                            case 1:
                                wrapDataPackage("Select imgname,imgdata from SERVERIMG order by countid asc");
                                oos.writeObject(listPackage);
                                break;
                            case 2:
                                wrapDataPackage("Select imgname,imgdata from SERVERIMGSIGNIN order by countid asc");
                                oos.writeObject(listPackage);
                                break;
                            case 3:
                                String data = dis.readUTF();
                                System.out.println(data);
                                String[] create = data.split(";");
                                Account a = signInQuest(create[0], create[1], Integer.parseInt(create[2]));
                                oos.writeObject(a);
                                break;
                        }
                        Thread.sleep(500);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    @Override
    public void wrapDataPackage(String query) {
        listPackage = new ArrayList<>();
        openSql();
        try {
            rs = st.executeQuery(query);
            while (rs.next()) {
                String imgName = rs.getString(1);
                byte[] imgData = rs.getBytes(2);
                listPackage.add(new ImageFromSql(imgName, imgData));
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
            System.out.println("Closed SQL");
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
            System.out.println("Closed Server");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Account signInQuest(String user, String password, int type) {
        openSql();
        try {
            rs = st.executeQuery("exec ST_SIGNIN '" + user + "','" + password + "','" + type+"'");
            while (rs.next()) {
              return new Account(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)));
            }
            closeSql();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
