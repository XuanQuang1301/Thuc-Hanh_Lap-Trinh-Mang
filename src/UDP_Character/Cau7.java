package UDP;

import java.net.*;

public class Cau7 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        int port = 808;

        // a. Gửi mã
        byte[] sendData = (";B15DCCN007;AB12CD34").getBytes();
        socket.send(new DatagramPacket(sendData, sendData.length, ip, port));

        // b. Nhận dữ liệu
        DatagramPacket packet = new DatagramPacket(new byte[2048], 2048);
        socket.receive(packet);
        String[] parts = new String(packet.getData(), 0, packet.getLength()).trim().split(";", 2);

        // c. Đếm tần suất và tìm max
        int[] count = new int[256];
        int max = 0;
        for (char c : parts[1].trim().toCharArray()) {
            count[c]++;
            if (count[c] > max) max = count[c];
        }

        StringBuilder ans = new StringBuilder();
        for (int cnt = max; cnt >= 1; cnt--) {
            for (int i = 0; i < 256; i++) {
                if (count[i] == cnt) {
                    ans.append((char) i).append(":").append(cnt).append(",");
                }
            }
        }

        // Xóa dấu phẩy thừa ở cuối chuỗi
        ans.deleteCharAt(ans.length() - 1);

        // Gửi kết quả
        byte[] out = (parts[0] + ";" + ans).getBytes();
        socket.send(new DatagramPacket(out, out.length, ip, port));

        // d. Đóng socket
        socket.close();
    }
}