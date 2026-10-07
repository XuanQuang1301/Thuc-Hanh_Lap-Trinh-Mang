/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Byte_Stream;
import java.util.*; 
import java.io.*; 
import java.net.*;
public class Cau3 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 806; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau3"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String request = name + ";" + qcode; 
            out.write(request.getBytes());
            out.flush();
            byte [] buffer = new byte[4096]; 
            int byteRead = in.read(buffer); 
            String response = new String(buffer, 0, byteRead).trim(); 
            String maxSub = ""; 
            for(int i = 0; i < response.length(); i++){
                String curr = ""; 
                for(int j = i; j < response.length(); j++){
                    char c = response.charAt(j); 
                    if(curr.indexOf(c) != -1){
                        break; 
                    }
                    curr += c; 
                }
                if(curr.length() > maxSub.length()){
                    maxSub = curr; 
                }
            }
            String ans = maxSub + ";" + maxSub.length(); 
            out.write(ans.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
