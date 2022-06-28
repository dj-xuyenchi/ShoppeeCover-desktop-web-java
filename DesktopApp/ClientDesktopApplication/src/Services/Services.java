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

    private List<ImageFromSql> listImgDecor1;
    private List<ImageFromSql> listImgDecor2;
    private Socket soc;
    private ObjectInputStream ois;

    public Services() {
    }

    @Override
    public List<ImageFromSql> getList() {
        return listImgDecor1;
    }

    @Override
    public List<ImageFromSql> getList1() {
        return listImgDecor2;
    }

    @Override
    public void conectServer() {
        try {
            soc = new Socket("localhost", 6969);
            System.out.println("Connected..");
            ois = new ObjectInputStream(soc.getInputStream());
            Object getOb1 = ois.readObject();
            listImgDecor1 = (List<ImageFromSql>) getOb1;
//            Object getOb2 = ois.readObject();
//            listImgDecor2 = (List<ImageFromSql>) getOb2;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
