package TCP_Data_Stream;

import java.io.*;
import java.net.*;

public class Cau6 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 807;
        String name = "B23DCCN686";
        String qcode = "0D135D6A";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // a. Gửi mã sinh viên và mã câu hỏi
            String request = name + ";" + qcode;
            out.writeUTF(request);
            out.flush();

            // b. Nhận số lần tung n và n giá trị xúc xắc
            int n = in.readInt();
            int[] count = new int[7]; // Mảng đếm từ mặt 1 đến mặt 6

            for (int i = 0; i < n; i++) {
                int val = in.readInt();
                if (val >= 1 && val <= 6) {
                    count[val]++;
                }
            }

            // c. Tính và gửi lần lượt xác suất của các mặt [1, 2, 3, 4, 5, 6]
            for (int i = 1; i <= 6; i++) {
                float prob = (float) count[i] / n;
                out.writeFloat(prob);
            }
            out.flush();

            // d. Kết nối tự đóng khi kết thúc khối try-with-resources
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}