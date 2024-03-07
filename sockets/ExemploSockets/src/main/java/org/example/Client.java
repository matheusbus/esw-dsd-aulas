package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Criando conexão...");
        
        try ( Socket conn = new Socket("10.15.120.198", 80)) {
            
            System.out.println("Conectado!");
            InputStream in = conn.getInputStream();
            
            byte[] dadosBrutos = new byte[1024];
            int qtdBytesLidos = in.read(dadosBrutos);
            while(qtdBytesLidos >= 0) {
                String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
                System.out.println(dadosStr);
                qtdBytesLidos = in.read(dadosBrutos);
            }
            
            
        } catch (UnknownHostException ex) {
            System.out.println("Host não encontrado");
            ex.printStackTrace();
        }
        
    }
}