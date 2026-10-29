/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;
import java.net.*; 
import java.util.*; 

public class eV5Cgyqf {
    public static void main(String[] args) throws Exception{
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242"); 
        byte []b = (";B23DCCN686;eV5Cgyqf").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2208));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String list[] = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        int count[] = new int[256]; 
        int max_c = -1; 
        String j = ""; 
        for(char c : list[1].toCharArray()){
            count[c]++; 
            if(count[c] > max_c){
                max_c = count[c]; 
                j = String.valueOf(c); 
            }
        }
        String ans = j + ":"; 
        for(int i = 0; i < list[1].length(); i++){
            if(count[list[1].charAt(i)] == max_c && j.equals(String.valueOf(list[1].charAt(i)))){
                ans += (i + 1) + ","; 
            }
        }
        byte[] bb = (list[0] + ";" + ans).getBytes(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2208));
    }
}
