/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package run;

import Services.Services;

/**
 *
 * @author PC
 */
public class ServerMain {

    public static void main(String[] args) {
        try {
            Services letGo = new Services(6969);
            letGo.openServer();
            letGo.acceptClient();
        } catch (Exception e) {
        }
    }
}
