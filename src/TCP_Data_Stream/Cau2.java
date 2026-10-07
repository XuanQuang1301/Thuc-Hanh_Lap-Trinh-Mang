/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*;
public class Cau2 {
    private static int uoc(int a, int b){
        while(b != 0){
            int tmp = a % b; 
            a = b; 
            b = tmp; 
        }
        return Math.abs(a); 
    }
    private static int boi(int a, int b){
        int uocchung = uoc(a, b); 
        return Math.abs(a * (b / uocchung)); 
    }
    public static void main(String[] args) {
        String server = "test"; 
        int port = 807; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau1";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            
            int a = in.readInt(); 
            int b = in.readInt(); 
            int uocchung = uoc(a, b); 
            int boichung = boi(a, b); 
            int tong = a + b; 
            int tich = a * b; 
            
            out.writeInt(uocchung);
            out.writeInt(boichung);
            out.writeInt(tong);
            out.writeInt(tich);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
