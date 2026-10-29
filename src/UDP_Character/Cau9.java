package UDP;

import java.net.*;
import java.util.*;

public class Cau9 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost"); // Thay bằng IP server thi nếu có
        int port = 808;

        // a. Gửi mã sinh viên và mã câu hỏi
        byte[] sendData = (";B15DCCN009;EF56GH78").getBytes();
        socket.send(new DatagramPacket(sendData, sendData.length, ip, port));

        // b. Nhận dữ liệu: "requestId;data"
        DatagramPacket packet = new DatagramPacket(new byte[2048], 2048);
        socket.receive(packet);

        String received = new String(packet.getData(), 0, packet.getLength()).trim();
        String[] parts = received.split(";", 2);
        String requestId = parts[0];
        String data = parts[1].trim();

        // c. Tách các từ và sắp xếp theo thứ tự từ điển ngược (z đến a)
        String[] words = data.split("\\s+");
        Arrays.sort(words, Collections.reverseOrder());

        // Nối các từ lại bằng dấu phẩy
        String processedData = String.join(",", words);

        // Gửi kết quả về server: "requestId;word1,word2,...,wordN"
        byte[] outBytes = (requestId + ";" + processedData).getBytes();
        socket.send(new DatagramPacket(outBytes, outBytes.length, ip, port));

        // d. Đóng socket
        socket.close();
    }
}