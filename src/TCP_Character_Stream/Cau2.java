package TCP_Character_Stream;

import java.io.*;
import java.net.*;

public class Cau2 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; // Thay bằng IP/Domain server phòng thi
        int port = 2208 ;
        String name = "B23DCCN686";
        String qcode = "Cau2"; 
        try(Socket socket = new Socket (server, port)){
            socket.setSoTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            String request = name + ";" + qcode; 
            out.write(request);
            out.newLine();
            out.flush();
            String response = in.readLine(); 
            String ans = ""; 
            int idxStart = -1; 
            int n = response.length(); 
            int i = 0; 
            while(i < n){
                while(i < n && Character.isWhitespace(response.charAt(i))){
                    i++; 
                }
                if (i >= n ) break; 
                int currStart = i; 
                while(i < n && !Character.isWhitespace(response.charAt(i))){
                    i++; 
                }
                String word = response.substring(currStart, i); 
                if(word.length() > ans.length()){
                    ans = word; 
                    idxStart = currStart; 
                }
            }
            out.write(ans);
            out.newLine();
            out.flush();
            out.write(String.valueOf(idxStart));
            out.newLine();
            out.flush();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}