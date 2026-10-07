/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class yIm9OzCT {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2207; 
        String name = "B23DCCN686"; 
        String qcode = "yIm9OzCT"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            int a = in.readInt(); 
            int b = in.readInt(); 
            int sum = a + b; 
            int tich = a * b; 
            out.writeInt(sum);
            out.writeInt(tich); 
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
}
