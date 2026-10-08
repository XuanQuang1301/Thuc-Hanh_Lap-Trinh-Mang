
package TCP;
import java.io.*; 
import java.net.*; 
import java.util.*; 


public class TCP_4Pj8vxNt {
    public static void main(String arg[]){
        String server = "36.50.135.242"; 
        int  port = 2206; 
        String name = "B23DCCN686"; 
        String qcode = "4Pj8vxNt"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String rq = name + ";" + qcode; 
            out.write(rq.getBytes());
            out.flush();
            byte buffer [] = new byte[4096]; 
            int len = in.read(buffer); 
            String response = new String(buffer, 0, len).trim(); 
            String list[] = response.split(","); 
            int num[] = new int[list.length]; 
            for(int i = 0; i < list.length; i++){
                num[i] = Integer.parseInt(list[i]); 
            }
            Arrays.sort(num);
            int min = Integer.MAX_VALUE; 
            int x = -1; 
            int y = -1; 
            for(int i = 1; i < num.length; i++){
                if(min > num[i] - num[i - 1]){
                    min = num[i] - num[i - 1]; 
                    x = num[i - 1]; 
                    y = num[i]; 
                }
            }
            String ans = min + "," + x + "," + y; 
            out.write(ans.getBytes());
            
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
