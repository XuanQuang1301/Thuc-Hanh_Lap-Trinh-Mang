/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau3 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 123; 
        String name = "B23DCCN686"; 
        String qcode = "123"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeObject(request);
            out.flush();
            
            Product product = (Product) in.readObject(); 
            String tmp = product.getPrice() + ""; 
            int ans = 0; 
            for(char c : tmp.toCharArray()) {
                if(c == '.') break; 
                ans += Integer.parseInt(c + ""); 
            }
            product.setDiscount(ans);
            out.writeObject(product);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
