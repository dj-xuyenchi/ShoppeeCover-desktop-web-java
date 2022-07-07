/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import Service.MoonNight.SSClass;

/**
 *
 * @author PC
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            SSClass letGo = new SSClass(6969);
            letGo.openServer();
            letGo.acceptClient();
        } catch (Exception e) {
        }
    }
}
