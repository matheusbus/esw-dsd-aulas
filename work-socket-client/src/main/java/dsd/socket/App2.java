package dsd.socket;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import dsd.socket.client.controller.ConnectionController;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus
 */
public class App2 {
    
    public static void main(String[] args) {
        FlatMaterialOceanicIJTheme.setup();
        ConnectionController connectionController = new ConnectionController();
    }
    
}
