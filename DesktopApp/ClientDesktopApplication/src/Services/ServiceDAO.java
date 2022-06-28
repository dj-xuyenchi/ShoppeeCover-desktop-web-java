/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ClassLib.ImageFromSql;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ServiceDAO {
    public List<ImageFromSql> getList();
    public List<ImageFromSql> getList1();
    public void conectServer();
}
