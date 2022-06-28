/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

/**
 *
 * @author PC
 */
public interface ServiceDAO {
    public void openServer();
    public void acceptClient();
    public void openSql();
    public void closeSql();
    public void closeServer();
    public void wrapDataPackage1();
}
