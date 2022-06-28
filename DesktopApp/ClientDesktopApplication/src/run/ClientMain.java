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
public class ClientMain {
    public static void main(String[] args) {
       Services client = new Services();
       client.conectServer();
    }
}
