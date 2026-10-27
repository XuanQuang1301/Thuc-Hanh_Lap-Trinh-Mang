/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Data_type;

import java.net.*; 
import java.util.*; 

public class Cau6 {
    public static void main(String[] args) throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("serrver"); 
        byte[] b = ("B23DCCN68").getBytes(); 
        
        s.send(new DatagramPacket(b, b.length, ip, 807));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String [] list = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String tmp = list[1].trim(); 
        int n = Integer.parseInt(list[2].trim());
        n %= 26; 
        StringBuilder ans = new StringBuilder(); 
        for(char c : tmp.toCharArray() ){
            if(c >= 'a' && c <= 'z'){
                char d = (char) ('a' + (c - 'a' - n + 26) % 26);  
                ans.append(d); 
            }
            else if(c >= 'A' && c <= 'Z'){
                char d = (char) ('A' + (c - 'A' - n + 26) % 26);  
                ans.append(d);
            }
            else ans.append(c); 
        }
        String ans2 = list[0] + ";" + ans; 
        byte [] a = ans2.getBytes(); 
        s.send(new DatagramPacket(a, a.length, ip, 807));
    }
}
