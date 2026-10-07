/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;
import TCP.Customer; 
import java.util.*;
import java.io.*; 
import java.net.*; 

public class Cau4 {
    private static String chuyenTen(String tmp){
        String [] list = tmp.trim().toLowerCase().split("\\s+"); 
        String lastName = list[list.length - 1]; 
        lastName = lastName.toUpperCase(); 
        String firstName = ""; 
        for(int i = 0; i < list.length - 1; i++){
            String ans = Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1); 
            firstName += ans; 
            if(i < list.length - 2){
                firstName += " "; 
            }
        }
        String result = lastName + ", " + firstName; 
        return result; 
    }
    private static String chuyenNgay(String day){
        String [] list = day.split("-"); 
        return list[1] + "/" + list[0] + "/" + list[2]; 
    }
    private static String chuyenUserName(String tmp){
        String [] list = tmp.trim().toLowerCase().split("\\s+"); 
        String lastName = list[list.length - 1]; 
        String firstName = ""; 
        for(int i = 0; i < list.length - 1; i++){
             firstName += list[i].charAt(0); 
        }
        String result = firstName + lastName; 
        return result; 
    }
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2209; 
        String name = "B23DCCN686"; 
        String qcode = "GZaw7mJT";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeObject(request);
            out.flush();
            Customer customer = (Customer) in.readObject(); 
            customer.setUserName(chuyenUserName(customer.getName()));
            customer.setName(chuyenTen(customer.getName()));
            customer.setDayOfBirth(chuyenNgay(customer.getDayOfBirth()));
            
            out.writeObject(customer);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
