
package UDP;
import java.util.*; 
import java.net.*; 

public class WrVNRw1O {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242"); 
        byte b[] = (";B23DCCN686;WrVNRw1O").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2207));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String list [] = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        int n = Integer.parseInt(list[1].trim()); 
        String list2[] = list[2].trim().split(","); 
        int count [] = new int[256];
        for(String c : list2){
            count[Integer.parseInt(c)]++; 
        }
        List<String> ans = new ArrayList<>(); 
        for(int i = 1; i <= n; i++){
            if(count[i] == 0){
                ans.add((i) + ""); 
            }
        }
        
        String tmp = String.join(",", ans); 
//        for(int i = 0; i < ans.size(); i++){
//            tmp += ans.get(i); 
//            if(i < ans.size() - 1){
//                tmp += ","; 
//            }
//        }
        byte []bb = (list[0] + ";" + tmp).getBytes(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2207));
    }
}