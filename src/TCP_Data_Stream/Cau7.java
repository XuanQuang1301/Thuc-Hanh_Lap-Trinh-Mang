package TCP_Data_Stream;

import java.io.*;
import java.net.*;

public class Cau7 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 807;
        String name = "B23DCCN686";
        String qcode = "D68C93F7";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // a. Gửi mã sinh viên và mã câu hỏi
            String request = name + ";" + qcode;
            out.writeUTF(request);
            out.flush();

            // b. Nhận số nguyên từ server
            int n = in.readInt();

            // c. Đổi sang chuỗi nhị phân
            String binaryString = Integer.toBinaryString(n);
            // Gửi chuỗi kết quả lên server
            out.writeUTF(binaryString);
            out.flush();

            // d. Kết nối tự đóng khi kết thúc try-with-resources
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// Hệ 2 -> Hệ 10
//String binStr = "101101";
//int decFromBin = Integer.parseInt(binStr, 2); // 45
//
//// Hệ 8 -> Hệ 10
//String octStr = "55";
//int decFromOct = Integer.parseInt(octStr, 8); // 45
//
//// Hệ 16 -> Hệ 10
//String hexStr = "2D"; // chữ hoa hay thường đều parse được
//int decFromHex = Integer.parseInt(hexStr, 16); // 45