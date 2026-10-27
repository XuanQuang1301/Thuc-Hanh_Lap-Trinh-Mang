
package UDP;

import java.util.*; 
import java.io.*;
import java.net.*;

public class Fz6kqvZ8 {
    private static String ten(String name){
        String list[] = name.trim().toLowerCase().split("\\s+"); 
        String ans = ""; 
        for(int i = 0; i < list.length; i++){
            ans += Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1); 
            if(i < list.length - 1){
                ans += " "; 
            }
        }
        return ans; 
    }
    private static String email(String mail){
        String list[] = mail.trim().toLowerCase().split("\\s+"); 
        String lastname = list[list.length - 1];
        String ans = ""; 
        for(int i = 0; i < list.length - 1; i++){
            ans += String.valueOf(list[i].charAt(0)); 
        }
        return lastname + ans + "@ptit.edu.vn"; 
    }
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242"); 
        byte[]b = (";B23DCCN686;Fz6kqvZ8").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2209));
        DatagramPacket d = new DatagramPacket(new byte[2048], 2048); 
        s.receive(d);
        byte [] data = d.getData(); 
        int len = d.getLength(); 
        
        byte[] rq = new byte[8]; 
        System.arraycopy(data, 0, rq, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, len - 8);
        ObjectInputStream ois = new ObjectInputStream(bais); 
        Student student = (Student) ois.readObject(); 
        student.setEmail(email(student.getName()));
        student.setName(ten(student.getName()));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        baos.write(rq);
        ObjectOutputStream oos = new ObjectOutputStream(baos); 
        oos.writeObject(student);
        oos.flush();
        byte [] bb = baos.toByteArray(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2209));
    }
}
