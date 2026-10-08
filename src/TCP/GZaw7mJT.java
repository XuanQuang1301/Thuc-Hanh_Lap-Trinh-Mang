/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*; 
import java.util.*; 
import java.net.*; 

public class GZaw7mJT {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2209; 
        String name = "B23DCCN686"; 
        String qcode = "GZaw7mJT"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream  in = new ObjectInputStream (socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String rq = name + ";" + qcode; 
            out.writeObject(rq);
            Customer customer = (Customer) in.readObject(); 
            String tmp = customer.getName().toLowerCase();
            String list[] = tmp.split("\\s+"); 
            String lastName = list[list.length - 1].toUpperCase(); 
            String first = ""; 
            for(int i  = 0; i < list.length - 1; i++){
                String ans = Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1); 
                first += ans + " "; 
            }
            customer.setName(lastName + ", " + first);
            String day[] = customer.getDayOfBirth().split("-"); 
            customer.setDayOfBirth(day[1] + "/" + day[0] + "/" + day[2]);
            String name2 = ""; 
            for(int i = 0; i < list.length - 1; i++){
                name2 += list[i].substring(0, 1); 
            }
            name2 = name2 + list[list.length - 1]; 
            customer.setUserName(name2);
            out.writeObject(customer);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
