    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package UDP_Object;

    import java.io.*; 
    import java.net.*; 
    import java.util.*; 

    public class Cau4 {
        private static String ten(String name){
            String list[] = name.trim().split("\\s+"); 
            String tmp = list[0]; 
            list[0] = list[list.length - 1]; 
            list[list.length - 1] = tmp; 
            String ans =""; 
            for(int i = 0; i < list.length; i++){
                ans += list[i]; 
                if(i < list.length - 1){
                    ans += " "; 
                }
            }
            return ans; 
        }
        private static int sl(int n){
            String tmp = n + ""; 
            String ans = "";
            for(int i = tmp.length() - 1; i >= 0; i--){
                ans += (tmp.charAt(i)); 
            }
            return Integer.parseInt(ans); 
        }
        public static void main(String[] args) throws Exception{
            DatagramSocket s = new DatagramSocket(); 
            InetAddress ip = InetAddress.getByName("server");
            byte []b = (";B23DCCN686;Cau4").getBytes(); 
            s.send(new DatagramPacket(b, b.length, ip, 809));
            DatagramPacket d = new DatagramPacket(new byte[2048], 2048); 
            s.receive(d);
            byte [] data = d.getData(); 
            int len = d.getLength(); 

            byte [] rq = new byte[8]; 
            System.arraycopy(data, 0, rq, 0, 8);
            ByteArrayInputStream bais = new ByteArrayInputStream(data, 8, len - 8); 
            ObjectInputStream ois = new ObjectInputStream(bais); 
            Product product = (Product) ois.readObject(); 
            product.setName(ten(product.getName()));
            product.setQuantity(sl(product.getQuantity()));

            ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
            baos.write(rq);
            ObjectOutputStream oos = new ObjectOutputStream(baos); 
            oos.writeObject(product);
            oos.flush();
            byte [] bb = baos.toByteArray(); 
            s.send(new DatagramPacket(bb, bb.length, ip, 809));
            s.close();
        }
    }
