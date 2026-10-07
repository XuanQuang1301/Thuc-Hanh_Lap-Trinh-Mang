/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau1 {
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
            int tong = a + b; 
            int tich = a * b; 
            out.writeInt(tong);
            out.writeInt(tich);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
