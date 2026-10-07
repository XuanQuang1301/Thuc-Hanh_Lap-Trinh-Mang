/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Byte_Stream;
import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau1 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 806; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau1"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String request = name + ";" + qcode; 
            out.write(request.getBytes());
            out.flush();
            byte [] buffer = new byte [4096]; 
            int byteRead = in.read(buffer); 
            String response = new String(buffer, 0, byteRead).trim(); 
            String [] list = response.split(",");
            int [] nums = new int[list.length];
            int max_1 = Integer.MIN_VALUE; 
            for(int i = 0; i < list.length; i++){
                nums[i] = Integer.parseInt(list[i]); 
                if(max_1 < nums[i]){
                    max_1 = nums[i]; 
                }
            }
            int max_2 = Integer.MIN_VALUE; 
            int idx = -1; 
            for(int i = 0; i < nums.length; i++){
                if(max_2 < nums[i] && nums[i] < max_1){
                    max_2 = nums[i]; 
                    idx = i; 
                }
            }
            String result = max_2 + "," + idx; 
            out.write(result.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
