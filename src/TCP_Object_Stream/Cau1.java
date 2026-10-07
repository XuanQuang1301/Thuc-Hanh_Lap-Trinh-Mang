/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;
 
import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau1 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 123; 
        String name = "B23DCCN686"; 
        String qcode = "Cau1"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeObject(request);
            out.flush();
            Student student = (Student) in.readObject();  
            float tmp = student.getGpa();
            if(tmp <= 4 && tmp > 3.7){
                student.setGpaLetter("A");
            }
            else if(tmp > 3.0){
                student.setGpaLetter("B");
            }
            else if(tmp > 2.0){
                student.setGpaLetter("C");
            }
            else if (tmp > 1.0) {
                student.setGpaLetter("D");
            }else student.setGpaLetter("F");
            out.writeObject(student);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
