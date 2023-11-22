/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaclient;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author gabriel.camargo5
 */
public class SocketTCP {
    
    public static boolean ConectaTcp(String host, int port){
         try {
            Socket s = new Socket(host, port); //Cria o socket e conecta no servidor
            OutputStream output = s.getOutputStream();
            InputStream input = s.getInputStream(); 
            
            int aux = 0;

            System.out.println("Sucesso na conexão, escreva uma mensagem para a porta: " + port);

            String cmd = "GET http://www.pousoalegre.mg.gov.br/css/toastr.min.css \r\n";
            output.write(cmd.getBytes()); 
            
            int count = 0;
             while(aux != -1){
                aux = input.read();
                if(aux != -1){
                    System.out.print((char)aux);
                    if(count > 100){
                        System.out.println("");
                        count = 0;
                    }
                    count++;
                }
            }
            
            return true;
        } catch (Exception err) { //SocketException ou IOException
            return false;
        }
    }
}
