

package TCP;

import java.io.*; 
import java.net.*; 
import java.util.*; 

public class pruou3s2 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2206; 
        String name = "B23DCCN686"; 
        String qcode = "pruou3s2"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String rq = name + ";" + qcode; 
            out.write(rq.getBytes());
            out.flush();
            byte [] buffer = new byte[4096]; 
            int len = in.read(buffer); 
            String response = new String(buffer, 0, len).trim(); 
            String [] list  = response.split(","); 
            int num[] = new int[list.length]; 
            int max1 = Integer.MIN_VALUE; 
            for(int i = 0; i < list.length; i++){
                num[i] = Integer.parseInt(list[i]); 
                max1 = Math.max(max1, num[i]); 
            }
            int max2 = Integer.MIN_VALUE; 
            int idx = -1; 
            for(int i = 0; i < list.length; i++){
                if(num[i]> max2 && num[i] < max1){
                    max2 = num[i]; 
                    idx = i; 
                }
            }
            String ans = max2 + "," + idx; 
            out.write(ans.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
