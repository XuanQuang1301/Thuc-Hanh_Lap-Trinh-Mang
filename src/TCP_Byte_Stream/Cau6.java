/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Byte_Stream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Cau6 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 806; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau4"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String request = name + ";" + qcode; 
            out.write(request.getBytes());
            out.flush();
            byte [] buffer = new byte[4096]; 
            int byteRead = in.read(buffer); 
            String response = new String(buffer, 0, byteRead).trim();
            List<Integer> num1 = new ArrayList<>(); 
            List<Integer> num2 = new ArrayList<>();
            String [] list = response.split(","); 
            for(String i: list){
                int tmp = Integer.parseInt(i); 
                if(tmp % 2 == 0){
                    num1.add(tmp);
                }else num2.add(tmp); 
            }
            Collections.sort(num1);
            Collections.sort(num2);
            String result = num1.toString() + ";" + num2.toString(); 
            out.write(result.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
