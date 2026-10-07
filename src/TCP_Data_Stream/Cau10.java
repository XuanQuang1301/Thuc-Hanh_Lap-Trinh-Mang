package TCP_Data_Stream;

import java.io.*;
import java.net.*;

public class Cau10 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 807;
        String name = "B23DCCN686";
        String qcode = "C6D7E8F9";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // a. Gửi mã sinh viên và mã câu hỏi
            String request = name + ";" + qcode;
            out.writeUTF(request);
            out.flush();

            // b. Nhận lần lượt số nguyên k và chuỗi mảng số nguyên
            int k = in.readInt();
            String response = in.readUTF().trim();

            String[] list = response.split(",");
            int n = list.length;
            String[] rotated = new String[n];

            // Chuẩn hóa k trong phạm vi [0, n - 1]
            k = (n > 0) ? (k % n + n) % n : 0;

            for (int i = 0; i < n; i++) {
                int newIndex = (i + k) % n;
                rotated[newIndex] = list[i].trim();
            }
            String result = String.join(",", rotated);
            out.writeUTF(result);
            out.flush();

            // d. Kết nối tự đóng khi kết thúc try-with-resources
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}