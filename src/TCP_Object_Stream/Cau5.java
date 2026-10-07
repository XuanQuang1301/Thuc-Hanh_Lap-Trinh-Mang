/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau5 {
    private static String chu(String tmp){
        String [] list = tmp.trim().toLowerCase().split("\\s+"); 
        String ans = ""; 
        for(int i = 0; i < list.length; i++){
            ans += Character.toUpperCase(list[i].charAt(0)) + list[i].substring(1) + " "; 
        }
        return ans; 
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
            Address address = (Address) in.readObject(); 
            address.setAddressLine(chu(address.getAddressLine()));
            String tmp = address.getPostalCode(); 
            String result = tmp.substring(0, 3) + "-" + tmp.substring(3); 
            address.setPostalCode(result);
            out.writeObject(address);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();; 
        }
    }
}
