package TCP;


import java.io.*; 
import java.net.*; 
import java.util.*; 

public class tnrxikH7 {
    public static void main(String[] args) {
        String server = "36.50.135.242"; 
        int port = 2208; 
        String name = "B23DCCN686"; 
        String qcode = "tnrxikH7"; 
        try(Socket socket = new Socket(server, port)){
            socket.setSoTimeout(50000);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
            String rq = name + ";" + qcode; 
            out.write(rq);
            out.newLine();
            out.flush();
            String response = in.readLine(); 
            String [] list = response.trim().split(",\\s+"); 
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
