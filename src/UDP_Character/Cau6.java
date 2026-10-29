package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cau6 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost"); // Thay bằng IP server thi
        int port = 808;

        // a. Gửi mã sinh viên và mã câu hỏi
        byte[] sendData = (";B15DCCN001;9F8C2D3A").getBytes();
        socket.send(new DatagramPacket(sendData, sendData.length, ip, port));

        // b. Nhận dữ liệu từ server: "requestId;data"
        DatagramPacket dataPacket = new DatagramPacket(new byte[2048], 2048);
        socket.receive(dataPacket);

        String received = new String(dataPacket.getData(), 0, dataPacket.getLength()).trim();
        String[] parts = received.split(";", 2);
        String requestId = parts[0];
        String data = parts[1].trim();

        // c. Đếm tần suất bằng mảng đếm 256 ký tự ASCII
        int[] count = new int[256];
        for (char c : data.toCharArray()) {
            count[c]++;
        }

        // Ghép chuỗi theo thứ tự xuất hiện ban đầu
        StringBuilder ans = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (count[c] > 0) {
                ans.append(count[c]).append(c);
                count[c] = 0; // Đặt về 0 để tránh ghép lặp lại ký tự này
            }
        }

        // Gửi kết quả về server: "requestId;processedData"
        byte[] resultData = (requestId + ";" + ans.toString()).getBytes();
        socket.send(new DatagramPacket(resultData, resultData.length, ip, port));

        // d. Đóng socket
        socket.close();
    }
}