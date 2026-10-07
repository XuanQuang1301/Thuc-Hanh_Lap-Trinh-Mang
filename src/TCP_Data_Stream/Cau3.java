/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*;
public class Cau3 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 807; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau3";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream  in = new DataInputStream (socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            int response = in.readInt(); 
            String bin = Integer.toBinaryString(response); 
            String hex = Integer.toHexString(response); 
            String result = bin + ";" + hex; 
            out.writeUTF(result);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
