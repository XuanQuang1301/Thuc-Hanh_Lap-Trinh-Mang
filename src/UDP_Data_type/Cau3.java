/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Data_type;

import java.net.*; 
import java.util.*; 

public class Cau3 {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("server"); 
        byte [] b = ("B23DCCN686").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 807));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String [] list = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String test = list[1].trim(); 
        int ans = 0; 
        for(int i = 0; i < test.length(); i++){
            ans += Integer.parseInt(String.valueOf(test.charAt(i))); 
        }
        String rs = list[0] + ";" + ans; 
        byte [] a = rs.getBytes(); 
        s.send(new DatagramPacket(a, a.length, ip, 807));
    }
}
