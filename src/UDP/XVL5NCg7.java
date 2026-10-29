/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;
import java.net.*; 
import java.io.*; 
import java.util.*; 

public class XVL5NCg7 {
    private static String ten(String name){
        String list[] = name.trim().toLowerCase().split("\\s+"); 
        String lastname = list[list.length - 1].toUpperCase().trim(); 
        String ans = ""; 
        for(int i = 0; i < list.length - 1; i++){
            ans += Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1); 
            if(i < list.length - 2){
                ans += " "; 
            }
        }
        return lastname + ", " + ans; 
    }
    private static String ngay(String ngay){
        String list[] = ngay.trim().split("-"); 
        return list[1] + "/" + list[0] + "/" + list[2]; 
    }
    private static String UName(String name){
        String list[] = name.trim().toLowerCase().split("\\s+");
        String lastname = list[list.length - 1]; 
        String ans = ""; 
        for(int i = 0; i < list.length - 1; i++){
            ans += (list[i].charAt(0)); 
            
        }
        return ans + lastname; 
    }
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip =  InetAddress.getByName("36.50.135.242"); 
        byte[] b = (";B23DCCN686;XVL5NCg7").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2209));
        DatagramPacket d = new DatagramPacket(new byte[2048], 2048); 
        s.receive(d);
        byte [] data = d.getData(); 
        int len = d.getLength(); 
        byte [] rq = new byte[8]; 
        System.arraycopy(data, 0, rq, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, len - 8); 
        ObjectInputStream ois = new ObjectInputStream(bais); 
        Customer customer = (Customer) ois.readObject(); 
        customer.setUserName(UName(customer.getName()));
        customer.setName(ten(customer.getName()));
        customer.setDayOfBirth(ngay(customer.getDayOfBirth()));
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        baos.write(rq);
        ObjectOutputStream oos = new ObjectOutputStream(baos); 
        oos.writeObject(customer);
        byte [] bb = baos.toByteArray(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2209));
    }
}
