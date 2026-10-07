

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
            int byteRead = in.read(buffer); 
            if(byteRead <= 0 ) return; 
            String response = new String(buffer, 0, byteRead).trim(); 
            String list[] = response.split(","); 
            int nums[] = new int[list.length]; 
            int num_max = Integer.MIN_VALUE; 
            for(int i = 0; i < list.length; i++){
                nums[i] = Integer.parseInt(list[i]); 
                if(nums[i] > num_max){
                    num_max = nums[i]; 
                }
            }
            int max2 = Integer.MIN_VALUE; 
            int idx = -1; 
            
            for(int i = 0; i < nums.length; i++){
                if(nums[i] < num_max && nums[i] > max2){
                    max2 = nums[i]; 
                    idx = i; 
                }
            }
            String result = max2 + "," + idx; 
            out.write(result.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
