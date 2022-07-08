/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import ModelLibraries.Account;
import Service.MidNight.CSI;
import ModelLibraries.ImageFromSql;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ClientServices implements CSI {

    private List<ImageFromSql> listImgDecor;
    private Socket soc;
    private ObjectInputStream ois;
    private DataOutputStream dos;
    private String ip;

    public ClientServices() {
        ip = "localhost";
    }

    @Override
    public List<ImageFromSql> getList() {
        return listImgDecor;
    }

    @Override
    public void connectServerAndOrderDecor(int order) {
        try {
            soc = new Socket(ip, 6969);
            ois = new ObjectInputStream(soc.getInputStream());
            dos = new DataOutputStream(soc.getOutputStream());
            dos.writeInt(order);
            Object getOb = ois.readObject();
            listImgDecor = (List<ImageFromSql>) getOb;
            closeConnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void closeConnect() {
        try {
            dos.close();
            ois.close();
            soc.close();
            System.out.println("Closed Connection");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Account signInQuest(String user, String pass, int typeSignIn) {
        try {
            soc = new Socket(ip, 6969);
            ois = new ObjectInputStream(soc.getInputStream());
            dos = new DataOutputStream(soc.getOutputStream());
            dos.writeInt(3);
            dos.writeUTF(user + ";" + pass + ";" + typeSignIn);
            Object returnData = ois.readObject();
            Account a = (Account) returnData;
            System.out.println(a.getId());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
