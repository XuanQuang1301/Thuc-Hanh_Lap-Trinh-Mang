package TCP_Character_Stream;

import java.io.*;
import java.net.*;

public class Cau4{
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 808;
        String name = "B23DCCN686";
        String qcode = "7D6265E3";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // a. Gửi mã sinh viên và mã câu hỏi
            String request = name + ";" + qcode;
            out.write(request);
            out.newLine();
            out.flush();

            String response = in.readLine(); 
            boolean visited [] = new boolean[256]; 
            StringBuilder ans = new StringBuilder(); 
            for(char c : response.toCharArray()){
                if(Character.isLetter(c)){
                    if(!visited[c]){
                        visited[c] = true; 
                        ans.append(c); 
                    }
                }
            }
            String tmp = ans.toString(); 
            out.write(tmp);
            out.newLine();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}