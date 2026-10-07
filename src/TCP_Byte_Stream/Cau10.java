package TCP_Byte_Stream;

import java.io.*;
import java.net.*;

public class Cau10 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 1; 
        String name = "B23DCCN686"; 
        String qcode = "Cau10"; 
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
            String list [] = response.split(","); 
            int num[] = new int[list.length]; 
            for(int i = 0; i < list.length; i++){
                num[i] = Integer.parseInt(list[i]); 
            }
            int start = -1; 
            int end = -1; 
            int max = Integer.MIN_VALUE; 
            for(int i = 0; i < num.length; i++){
                int tmp = 0; 
                for(int j = i; j < num.length; j++){
                    tmp += num[i]; 
                    if(tmp % 3 == 0){
                        int length = j - i + 1; 
                        if(length > max){
                            max = length; 
                            start = i; 
                            end = j; 
                        }
                    }
                }
            }
            String result = start + "," + end; 
            out.write(result.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}