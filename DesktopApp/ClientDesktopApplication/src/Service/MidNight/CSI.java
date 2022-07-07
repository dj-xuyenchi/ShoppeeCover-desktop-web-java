/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.MidNight;

import ModelLibraries.ImageFromSql;
import java.util.List;

/**
 * Client Service Interfaces
 * @author PC
 */
public interface CSI {
    public List<ImageFromSql> getList();
    public List<ImageFromSql> getList1();
    public void conectServer();
}
