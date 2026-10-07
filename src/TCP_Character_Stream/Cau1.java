/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Character_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*; 

public class Cau1 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; // Thay bằng IP/Domain server phòng thi
        int port = 2208 ;
        String name = "B23DCCN686";
        String qcode = "tnrxikH7";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            String request = name + ";" + qcode; 
            out.write(request);
            out.newLine();
            out.flush();
            String response = in.readLine(); 
            String list [] = response.split(",\\s+"); 
            List<String> ans = new ArrayList<>(); 
            for(int i = 0; i < list.length; i++){
                if(list[i].endsWith(".edu")){
                    ans.add(list[i]);
                }
            }
            String result = String.join(", ", ans); 
            out.write(result);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
