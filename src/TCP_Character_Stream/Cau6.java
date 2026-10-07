/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Character_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau6 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; // Thay bằng IP/Domain server phòng thi
        int port = 2208 ;
        String name = "B23DCCN686";
        String qcode = "tnrxikH7";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream())); 
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            String request = name + ";" + qcode; 
            out.write(request);
            out.newLine();
            out.flush();
            String tmp1 = in.readLine(); 
            String tmp2 = in.readLine(); 
            int count[] = new int[256]; 
            for(char c : tmp2.toCharArray()){
                count[c]++;
            }
            StringBuilder ans = new StringBuilder(); 
            for(char c : tmp1.toCharArray()){
                if(count[c] < 1){
                    ans.append(c); 
                }
            }
            String result = ans.toString(); 
            out.write(result);
            out.newLine();
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
