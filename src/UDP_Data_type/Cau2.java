/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Data_type;
import java.net.*; 

public class Cau2 {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip =  InetAddress.getByName(""); 
        byte[] b = (";B23DCCN686;cau2").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 807));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String []list = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String q = list[0].trim(); 
        String [] list2 = list[1].trim().split(","); 
        String[] ans = new String [list2.length + 1];
        for(int i = 0; i < list2.length; i++){
            String tmp2[] = list2[1].trim().split(":"); 
            int idx = Integer.parseInt(tmp2[1]); 
            ans[idx] = tmp2[0]; 
        }
        String t = ""; 
        for(int i = 1; i < ans.length; i++){
            t += ans[i]; 
        }
        String result = q + ";" + t; 
        byte[] a = result.getBytes(); 
        s.send(new DatagramPacket(a, a.length, ip, 807));
    }
}
