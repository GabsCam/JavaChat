/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaserver;

import java.net.*;
import java.io.*;
public class SimpleJavaServer {
	public static void main(String[] args) {
		try {
			//cria o socket do servidorr
		       	ServerSocket s = new ServerSocket(4567); //Cria o socket do servidor, porta 4567
		       	String str;
		        while(true) {
				System.out.println("Aguardando o cliente conectar");
				Socket c =s.accept(); //Fica bloqueado esperando uma solicita��o de conex�o
				System.out.println("Cliente conectado");				
			      	InputStream i = c.getInputStream();//Pega o stream de entrada do socket
			      	OutputStream o = c.getOutputStream();//Pega o stream de sa�da do socket
			     	do {
			        	byte[] line = new byte[100];
					System.out.println("Esperando o cliente enviar uma mensagem");
				        i.read(line);                    //le a solicitacao do cliente
				        o.write(line);	    //devolve a mesma mensagem para o cliente
			         	str = new String(line);
				 	System.out.println("Servidor recebeu = " + str);
			       	} while ( !str.trim().equals("sair") );  //Enquanto a a msg for diferente de bye
			      	c.close();
		        }
		}  catch (Exception err) {        //SocketException ou IOException
		       System.err.println(err);
		}
	}
}