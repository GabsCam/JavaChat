/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavaclient;

import java.net.*;
import java.io.*;

public class SimpleJavaClient {

    public static void main(String[] args) {
        //for(int i = 4560; i < 4570; i++)
            System.out.println((SocketTCP.ConectaTcp("www.pousoalegre.mg.gov.br", 80) ? "\nConectado em: " : "Falha na conexão na porta: ") + 80);
    }
}
