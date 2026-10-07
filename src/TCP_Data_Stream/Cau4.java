/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*;

public class Cau4 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 807; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau4";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream  in = new DataInputStream (socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            String response = in.readUTF(); 
            int tmp = in.readInt(); 
            tmp = (tmp % 26 + 26) % 26; 
            StringBuilder ans = new StringBuilder(); 
            for(char c : response.toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    char d = (char)('a' + (c - 'a' - tmp + 26) % 26); 
                    ans.append(d); 
                }else if(c >= 'A' && c <= 'Z'){
                    char d = (char)('A' + (c - 'A' - tmp + 26) % 26); 
                    ans.append(d);
                }else ans.append(c);
            }
            out.writeUTF(ans.toString());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
