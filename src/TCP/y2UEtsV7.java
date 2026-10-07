/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*; 
import java.util.*; 
import java.net.*; 

public class y2UEtsV7 {
    private static int reverseNumber(int n) {
        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        return Integer.parseInt(reversedStr);
    }
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2209 ; 
        String name = "B23DCCN686"; 
        String qcode = "y2UEtsV7"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            ObjectInputStream in = new ObjectInputStream (socket.getInputStream()); 
            String rq = name + ";"+ qcode; 
            out.writeObject(rq);
            out.flush();
            Laptop laptop = (Laptop) in.readObject(); 
            String lapTopname = laptop.getName().trim(); 
            String [] word = lapTopname.split("\\s+"); 
            if(word.length > 1){
                String temp = word[0]; 
                word[0] = word[word.length - 1]; 
                word[word.length - 1] = temp; 
                laptop.setName(String.join(" ", word));
            }
            
            int reversedQuantity = reverseNumber(laptop.getQuantity()); 
            laptop.setQuantity(reversedQuantity);
            out.writeObject(laptop);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
