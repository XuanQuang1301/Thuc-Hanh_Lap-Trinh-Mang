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
        String q = "B23DCCN686"; 
        String qcode = "GZaw7mJT"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream in = new ObjectInputStream (socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String rq = q + ";" + qcode; 
            out.writeObject(rq);
            out.flush();
            Customer customer = (Customer) in.readObject();
            String tmpName = customer.getName().trim().toLowerCase(); 
            String [] word = tmpName.split("\\s+"); 
            String lastname = word[word.length - 1].toUpperCase(); 
            StringBuilder name = new StringBuilder(); 
            for(int i = 0; i < word.length - 1; i++){
                String w = word[i]; 
                String ww = Character.toUpperCase(w.charAt(0)) + w.substring(1); 
                name.append(ww); 
                if(i < word.length - 2){
                    name.append(" "); 
                }
            }
            String resultName = lastname + ", " + name.toString(); 
            customer.setName(resultName);
            String[] dobpart = customer.getDayOfBirth().trim().split("-"); 
            String resultDob = dobpart[1] + "/" + dobpart[0] + "/" + dobpart[2]; 
            customer.setDayOfBirth(resultDob);
            
            StringBuilder username = new StringBuilder(); 
            for(int i = 0; i < word.length - 1; i++){
                username.append(word[i].charAt(0)); 
            }
            username.append(word[word.length - 1]); 
            customer.setUserName(username.toString());
            out.writeObject(customer);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
