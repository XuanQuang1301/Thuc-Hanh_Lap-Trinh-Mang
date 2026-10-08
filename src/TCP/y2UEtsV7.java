/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;
import TCP.Laptop; 
import java.io.*; 
import java.util.*; 
import java.net.*; 

public class y2UEtsV7 {
    private static String chuyenten(String name){
        String list[] = name.split("\\s+"); 
        if(list.length > 1){
            String tmp  = list[0]; 
            list[0] = list[list.length - 1]; 
            list[list.length - 1] = tmp; 
        }
        return String.join(" ", list); 
    }
    private static int soluong(int n){
        StringBuilder ans = new StringBuilder(n + ""); 
        return Integer.parseInt(ans.reverse().toString()); 
    }
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2209 ; 
        String name = "B23DCCN686"; 
        String qcode = "y2UEtsV7"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream  in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String rq = name + ";" + qcode; 
            out.writeObject(rq);
            out.flush();
            Laptop laptop = (Laptop) in.readObject(); 
            laptop.setName(chuyenten(laptop.getName()));
            laptop.setQuantity(soluong(laptop.getQuantity()));
            out.writeObject(laptop);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
