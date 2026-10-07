/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;
import java.util.*; 
import java.io.*; 
import java.net.*; 

public class bs6jkf1i {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2207; 
        String name = "B23DCCN686"; 
        String qcode = "bs6jkf1i"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            String encode = in.readUTF(); 
            int s = in.readInt(); 
            int shift = (s % 26); 
            StringBuilder decode = new StringBuilder(); 
            for(char c : encode.toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    char d = (char)('a' + (c - 'a' - shift + 26) % 26);
                    decode.append(d); 
                }
                else if(c >= 'A' && c <= 'Z'){
                    char d = (char)('A' + (c - 'A' - shift + 26) % 26);
                    decode.append(d);  
                }else{
                    decode.append(c); 
                }
 
            }
            String result = decode.toString(); 
            out.writeUTF(result);
            out.flush();
        }catch(Exception e){
            
        }
    }
}
