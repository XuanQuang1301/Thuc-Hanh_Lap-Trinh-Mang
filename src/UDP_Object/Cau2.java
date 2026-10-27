/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP_Object;
import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau2 {
    private  static String ten(String name){
        String list[] = name.trim().toLowerCase().split("\\s+"); 
        String ans = ""; 
        for(int i = 0; i < list.length; i++){
            String d = Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1); 
            ans += d; 
            if(i < list.length - 1){
                ans += " "; 
            }
        }
        return ans; 
    }
    private static double luong(double luong, String ngay){
        String list[] = ngay.trim().split("-"); 
        String tmp = list[0].trim(); 
        int ans = 0; 
        for(int i = 0; i < tmp.length(); i++){
            ans += (tmp.charAt(i) - '0');  
        }
        return (double) (luong + luong * ((double)ans / 100)); 
    }
    private static String ngay(String day){
        String list[] = day.trim().split("-"); 
        return list[2] + "/" + list[1] + "/" + list[0]; 
    }
    public static void main(String[] args) throws Exception{
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("server"); 
        byte b[] = (";B23DCCN686;cau2").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 807));
        DatagramPacket d = new DatagramPacket(new byte[2048], 2048);
        s.receive(d);
        
        byte[] data = d.getData(); 
        int len = d.getLength(); 
        
        byte[] rq = new byte[8]; 
        System.arraycopy(data, 0, rq, 0, 8);
        ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, len - 8); 
        ObjectInputStream ois = new ObjectInputStream(bais); 
        Employee employee = (Employee) ois.readObject(); 
        employee.setName(ten(employee.getName()));
        employee.setSalary(luong(employee.getSalary(), employee.getHireDate()));
        employee.setHireDate(ngay(employee.getHireDate()));
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        baos.write(rq);
        ObjectOutputStream oos = new ObjectOutputStream(baos); 
        oos.writeObject(employee);
        byte [] bb = baos.toByteArray(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 807));
    }
}
