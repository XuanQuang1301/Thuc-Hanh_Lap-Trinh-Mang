package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cau2 {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            // Địa chỉ IP của Server (thay đổi theo đề bài nếu có IP cụ thể)
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 808;

            // a. Gửi mã sinh viên và mã câu hỏi
            String sendInit = ";B15DCCN000;XbYdNZ3";
            byte[] sendData1 = sendInit.getBytes();
            DatagramPacket sendPacket1 = new DatagramPacket(sendData1, sendData1.length, serverAddress, serverPort);
            socket.send(sendPacket1);

            // b. Nhận thông điệp từ server: "requestId;b1,b2"
            byte[] receiveBuffer = new byte[2048];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            String receivedStr = new String(receivePacket.getData(), 0, receivePacket.getLength()).trim();
            // Tách requestId và phần dữ liệu
            String[] parts = receivedStr.split(";");
            String requestId = parts[0];
            
            // Tách 2 số nhị phân b1 và b2
            String[] binaryNumbers = parts[1].split(",");
            String b1 = binaryNumbers[0].trim();
            String b2 = binaryNumbers[1].trim();

            // c. Chuyển từ nhị phân sang thập phân và tính tổng
            // Dùng Long.parseLong(s, 2) để tránh tràn số với các chuỗi nhị phân dài
            long num1 = Long.parseLong(b1, 2);
            long num2 = Long.parseLong(b2, 2);
            long sum = num1 + num2;

            // Gửi lại kết quả theo định dạng: "requestId;sum"
            String resultStr = requestId + ";" + sum;
            byte[] sendData2 = resultStr.getBytes();
            DatagramPacket sendPacket2 = new DatagramPacket(sendData2, sendData2.length, serverAddress, serverPort);
            socket.send(sendPacket2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // d. Đóng socket và kết thúc
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}