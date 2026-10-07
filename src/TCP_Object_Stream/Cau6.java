/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 
public class Cau6 {
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
            EmployeePerformance employee = (EmployeePerformance) in.readObject(); 
            
            List<Integer> list = employee.getMonthlyScores(); 
            float tmp = 0; 
            for(int i = 0; i < list.size(); i++){
                tmp += (float) list.get(i); 
            }
            tmp = (float) tmp / list.size(); 
            employee.setAvgScore(tmp);
            if(tmp >= 90){
                employee.setRating("Excellent");
            }else if(tmp >= 75){
                employee.setRating("Good");
            }else if(tmp >= 60) {
                employee.setRating("Average");
            }
            else employee.setRating("Poor");
            out.writeObject(employee); 
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
