/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Data_type;

import java.net.*; 
import java.util.*; 

public class Cau9 {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("server"); 
        byte [] b  = (";B23DCCN686;Cau9").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 807));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String [] list = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        int n = Integer.parseInt(list[1].trim()); 
        int k = Integer.parseInt(list[2].trim()); 
        String ans = ""; 
        String [] list2 = list[3].trim().split(","); 
        int [] num = new int[list2.length]; 
        for(int i = 0; i < list2.length; i++){
            num[i] = Integer.parseInt(list2[i].trim()); 
        }
        for(int i = 0; i < n - k + 1; i++){
            int tmp = num[i]; 
            for(int j = i; j < i + k; j++){
                tmp = Math.max(num[j], tmp); 
            }
            ans += tmp + ","; 
        }
        ans = list[0] + ";" +  ans; 
        byte[]a = ans.getBytes(); 
        s.send(new DatagramPacket(a, a.length, ip, 807));
        s.close();
    }
}
