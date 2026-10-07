
package TCP;

import java.io.*; 
import java.net.*; 
import java.util.*; 

public class TCP_0yyLBLEJ {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2208; 
        String name = "B23DCCN686"; 
        String qCode = "0yyLBLEJ"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            String rq = name + ";" + qCode; 
            out.write(rq);
            out.newLine();
            out.flush();
            String response = in.readLine();
            if(response != null && !response.trim().isEmpty()){
                int count[] = new int[255]; 
                for(char c : response.toCharArray()){
                    if(Character.isLetterOrDigit(c)){
                        count[c]++; 
                    }
                }
                StringBuilder result = new StringBuilder(); 
                for(char c : response.toCharArray()){
                    if(Character.isLetterOrDigit(c) && count[c] > 1){
                        result.append(c).append(":").append(count[c]).append(","); 
                        count[c] = 0;
                    }
                }
                String tmp = result.toString(); 
                out.write(tmp);
                out.flush();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
