package UDP_Data_type;

import java.math.BigInteger;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cau10 {
    public static void main(String[] args) throws Exception {
        DatagramSocket s = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109"); // Đổi IP server tương ứng
        int port = 807;

        // a. Gửi thông điệp: ";studentCode;qCode"
        byte[] b = ";B23DCCN686;D3F9A7B8".getBytes();
        s.send(new DatagramPacket(b, b.length, ip, port));

        // b. Nhận thông điệp dạng: "requestId;a;b"
        DatagramPacket data = new DatagramPacket(new byte[2048], 2048);
        s.receive(data);

        String raw = new String(data.getData(), 0, data.getLength()).trim();
        String[] parts = raw.split(";");

        String requestId = parts[0].trim();
        BigInteger numA = new BigInteger(parts[1].trim());
        BigInteger numB = new BigInteger(parts[2].trim());

        // c. Tính tổng (sum) và hiệu (difference = a - b)
        BigInteger sum = numA.add(numB);
        BigInteger diff = numA.subtract(numB);

        // Chuỗi gửi lại: "requestId;sum;difference"
        String ans = requestId + ";" + sum + ";" + diff;

        byte[] a = ans.getBytes();
        s.send(new DatagramPacket(a, a.length, data.getAddress(), data.getPort()));

        // d. Đóng socket
        s.close();
    }
}