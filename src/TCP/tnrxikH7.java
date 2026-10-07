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
           socket.setSoTimeout(5000);
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
           BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
           String request = name + ";" + qcode; 
           out.write(request);
           out.newLine();
           out.flush();
           String response = in.readLine(); 
           if(response != null && !response.trim().isEmpty()){
               String domains[] = response.split(",\\s+"); 
               List<String> list = new ArrayList<>(); 
               String result = ""; 
               for(int i = 0; i < domains.length; i++){
                   if(domains[i].trim().endsWith(".edu")){
                       list.add(domains[i]); 
                   }
               }
               result = String.join(", ", list); 
               out.write(result.trim());
               out.flush();
           }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
