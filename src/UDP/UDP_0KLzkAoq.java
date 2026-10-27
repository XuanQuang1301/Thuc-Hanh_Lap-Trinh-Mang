/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;
import java.nio.*; 
import java.net.*; 

public class UDP_0KLzkAoq {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242");
        byte[] b = (";B23DCCN686;0KLzkAoq").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2208));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String list[] = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String list2[] = list[1].trim().toLowerCase().split("\\s+"); 
        String ans = ""; 
        for(int i = 0; i < list2.length; i++){
            ans += Character.toUpperCase(list2[i].charAt(0)) + list2[i].substring(1) + " "; 
        }
        String d = list[0] + ";" + ans.trim(); 
        byte[] bb = d.getBytes(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2208));
        
    }
}
