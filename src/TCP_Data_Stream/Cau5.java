/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;

import java.util.*; 
import java.io.*; 
import java.net.*;
public class Cau5 {
    public static void main(String[] args) {
        String server = "test"; 
        int port = 807; 
        String  name= "B23DCCN686"; 
        String qcode = "Cau4";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream  in = new DataInputStream (socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
            String request = name + ";" + qcode; 
            out.writeUTF(request);
            out.flush();
            int n = in.readInt(); 
            int num[] = new int[n]; 
            int sum = 0; 
            for(int i = 0; i < n; i++){
                num[i] = in.readInt(); 
                sum += num[i]; 
            }
            float tbc = (float) sum / n; 
            float ans = 0; 
            for(int i = 0; i < n;i++){
                ans += (num[i] - tbc) * (num[i] - tbc); 
            }
            ans /= n; 
            out.writeInt(sum);
            out.writeFloat(tbc);
            out.writeFloat(ans);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
