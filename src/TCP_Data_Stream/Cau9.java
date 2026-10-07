/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Data_Stream;


import java.io.*;
import java.net.*;
import java.util.*; 

public class Cau9 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 807;
        String name = "B23DCCN686";
        String qcode = "D68C93F7";
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String request = name + ";" + qcode;
            out.writeUTF(request);
            out.flush();
            String response = in.readUTF().trim(); 
            String list [] = response.split(","); 
            int [] num = new int [list.length]; 
            for(int i = 0; i < list.length; i++){
                num[i]= Integer.parseInt(list[i]); 
            }
            int dp[] = new int [num.length]; 
            int trace [] = new int [num.length]; 
            Arrays.fill(dp, 1);
            Arrays.fill(trace, -1);
            int maxLen = 0; 
            int idx = -1; 
            for(int i = 0; i < num.length; i++){
                for(int j = 0; j < i; j++){
                    if(num[j] < num[i] && dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1; 
                        trace[i] = j; 
                    }
                }
                if(dp[i] > maxLen){
                    maxLen = dp[i]; 
                    idx = i; 
                }
            }
            List<Integer> ans = new ArrayList<>(); 
            int curr = idx; 
            while(curr != -1){
                ans.add(num[curr]); 
                curr = trace[curr]; 
            }
            Collections.reverse(ans);
            StringBuilder result = new StringBuilder(); 
            for(int i = 0; i < ans.size(); i++){
                result.append(ans.get(i)); 
                if(i < ans.size() - 1){
                    result.append(","); 
                }
            }
            String str = result.toString(); 
            out.writeUTF(str);
            out.writeInt(maxLen);
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
