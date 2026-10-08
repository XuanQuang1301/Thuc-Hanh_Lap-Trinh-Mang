
package TCP;

import java.io.*; 
import java.net.*; 
import java.util.*; 

public class TCP_0yyLBLEJ {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2208; 
        String name = "B23DCCN686"; 
        String qcode = "0yyLBLEJ"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            String rq = name + ";"+ qcode; 
            out.write(rq);
            out.newLine();
            out.flush();
            String response = in.readLine().trim(); 
            int count[] = new int[256]; 
            for(int i  = 0; i < response.length(); i++){
                if(Character.isLetterOrDigit(response.charAt(i))){
                    count[response.charAt(i)]++; 
                }
            }
            StringBuilder ans = new StringBuilder(); 
            for(char c: response.toCharArray()){
                if(count[c] > 1){
                    ans.append(c).append(":").append(count[c]).append(","); 
                    count[c] = 0; 
                }
            }
            String tmp = ans.toString(); 
            out.write(tmp);
            out.newLine();
            out.flush();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
