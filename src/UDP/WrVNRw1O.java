
package UDP;
import java.util.*; 
import java.net.*; 

public class WrVNRw1O {
    public static void main(String[] args)throws Exception {
        DatagramSocket s = new DatagramSocket(); 
        InetAddress ip = InetAddress.getByName("36.50.135.242"); 
        byte [] b = (";B23DCCN686;WrVNRw1O").getBytes(); 
        s.send(new DatagramPacket(b, b.length, ip, 2207));
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048); 
        s.receive(data);
        String list[] = new String(data.getData(), 0, data.getLength()).trim().split(";"); 
        String rq = list[0].trim(); 
        int n = Integer.parseInt(list[1].trim()); 
        String list2[] = list[2].trim().split(","); 
        int count[] = new int[n + 1]; 
        for(int i = 0; i < list2.length; i++){
            count[Integer.parseInt(list2[i])]++; 
            System.out.println(list[2]);
        }
        List<String> ans = new ArrayList<>(); 
        for(int i = 1; i <= n; i++){
            if(count[i] == 0){
                ans.add(i + ""); 
                System.out.println(i);
            }
        }
        String tmp = ""; 
        for(int i = 0; i < ans.size(); i++){
            tmp += ans.get(i); 
            if(i < ans.size() - 1){
                tmp += ","; 
            }
        }
        String d = rq + ";" + tmp; 
        byte[]bb = d.getBytes(); 
        s.send(new DatagramPacket(bb, bb.length, ip, 2207));
    }
}