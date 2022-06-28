/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import ClassLib.ImageFromSql;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Services implements ServiceDAO {

    private List<ImageFromSql> listImgDecor;
    private Socket soc;
    private ObjectInputStream ois;

    public Services() {
    }

    @Override
    public void conectServer() {
        try {
            soc = new Socket("localhost", 6969);
            System.out.println("Connected..");
            ois = new ObjectInputStream(soc.getInputStream());
            Object getOb = ois.readObject();
            listImgDecor = (List<ImageFromSql>) getOb;
            System.out.println(listImgDecor.get(0).getName());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
