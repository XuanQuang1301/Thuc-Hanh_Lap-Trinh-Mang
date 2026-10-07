
package TCP;
import java.io.*; 
import java.net.*; 
import java.util.*; 


public class TCP_4Pj8vxNt {
    public static void main(String arg[]){
        String server = "36.50.135.242"; 
        int  qServer = 2206; 
        String name = "B23DCCN686"; 
        String qCode = "4Pj8vxNt"; 
        try(Socket socket = new Socket(server, qServer)){
            socket.setSoTimeout(5000);
            InputStream in = socket.getInputStream(); 
            OutputStream out = socket.getOutputStream(); 
            String rq = name + ";" + qCode; 
            out.write(rq.getBytes());
            out.flush();
            byte[] buffer = new byte[4096]; 
            int byteRead = in.read(buffer); 
            if(byteRead <= 0 ) return; 
            String response = new String(buffer, 0, byteRead).trim(); 
            String list[] = response.split(","); 
            int nums[] = new int[list.length]; 
            for(int i = 0; i < list.length; i++){
                nums[i] = Integer.parseInt(list[i]); 
            }
            Arrays.sort(nums);
            int num1 = -1; 
            int num2 = -1; 
            int tmp = Integer.MAX_VALUE; 
            for(int i = 1; i < nums.length; i++){
                if(nums[i] - nums[i - 1] < tmp){
                    num1 = nums[i - 1]; 
                    num2 = nums[i]; 
                    tmp = nums[i] - nums[i - 1]; 
                }
            }
            String result = tmp + "," + num1 + "," + num2; 
            out.write(result.getBytes());
            out.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
