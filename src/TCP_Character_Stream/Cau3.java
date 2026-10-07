/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Character_Stream;
import java.util.*; 
import java.net.*; 
import java.io.*; 

public class Cau3 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 808;
        String name = "B23DCCN686";
        String qcode = "Cau3";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String request = name + ";" + qcode; 
            out.write(request);
            out.newLine();
            out.flush();
            String response = in.readLine(); 
            StringBuilder ans1 = new StringBuilder(); 
            StringBuilder ans2 = new StringBuilder(); 
            for(char c : response.toCharArray()){
                if (Character.isLetterOrDigit(c)) {
                    ans1.append(c);
                } else {
                    ans2.append(c);
                }
            }
            String tmp1 = ans1.toString(); 
            String tmp2 = ans2.toString(); 
            out.write(tmp1);
            out.newLine();
            out.flush();
            out.write(tmp2);
            out.newLine();
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
