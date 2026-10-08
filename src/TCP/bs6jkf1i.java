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
            String rq = name + ";" + qcode; 
            out.writeUTF(rq);
            out.flush();
            String response = in.readUTF(); 
            int n = in.readInt(); 
            n = n % 26; 
            StringBuilder ans = new StringBuilder(); 
            for(char c: response.toCharArray()){
                if(c >= 'a' && c <= 'z'){
                    char d = (char) ('a' + (c - 'a' - n + 26) % 26);
                    ans.append(d); 
                }
                else if(c >= 'A' && c <='Z'){
                    char d = (char) ('A' + (c - 'A' - n + 26) % 26);
                    ans.append(d);
                } else ans.append(c); 
            }
            String tmp = ans.toString(); 
            out.writeUTF(tmp);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
