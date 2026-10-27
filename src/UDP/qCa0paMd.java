package UDP;

import java.net.*; 
import java.util.*; 
import java.nio.*; 

public class qCa0paMd {
    public static void main(String[] args) throws Exception{
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242"); 
        byte [] b = (";B23DCCN686;qCa0paMd").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2207));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String list[] = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String list2 [] = list[1].trim().split(","); 
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 
        for(int i = 0; i < list2.length; i++){
            int tmp = Integer.parseInt(list2[i]); 
            max = Math.max(max, tmp); 
            min = Math.min(min, tmp); 
        }
        String ans  =  list[0] + ";" + max + "," + min; 
        byte[] bb = ans.getBytes(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2207));
    }
}
