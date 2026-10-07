/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;
import TCP.Laptop;
import java.util.* ; 
import java.io.*; 
import java.net.*; 

public class Cau2 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2209; 
        String name = "B23DCCN686"; 
        String qcode = "y2UEtsV7";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeObject(request);
            out.flush();
            Laptop laptop = (Laptop) in.readObject();
            
            String tmp = laptop.getName().trim(); 
            String list[] = tmp.split("\\s+"); 
            if(list.length > 1){
                String tmp1 = list[list.length - 1]; 
                list[list.length - 1] = list[0]; 
                list[0] = tmp1; 
                laptop.setName(String.join(" ", list));
            }
            String ans = new StringBuilder(laptop.getQuantity() + "").reverse().toString();  
            laptop.setQuantity(Integer.parseInt(ans));
            out.writeObject(laptop);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
