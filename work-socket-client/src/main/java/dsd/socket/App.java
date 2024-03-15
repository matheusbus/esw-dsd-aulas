/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author matheus
 */
public class App {

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner s = new Scanner(System.in);
        
        try {
            while (true) {
                // Conectar ao servidor na porta 12345
                Socket socket = new Socket("192.168.2.104", 12345);

                // Fluxo de saída para enviar dados para o servidor
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Enviar mensagem para o servidor
                System.out.print("Digite sua mensagem: ");
                out.println(s.nextLine());

                // Fluxo de entrada para receber resposta do servidor
                //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Ler resposta do servidor
                //String response = in.readLine();
                //System.out.println("Resposta do servidor: " + response);

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Object o = in.readObject();
                System.out.println(o.toString());
                
                
                // Fechar recursos
                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
