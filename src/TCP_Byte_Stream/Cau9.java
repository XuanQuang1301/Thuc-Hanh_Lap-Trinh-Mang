package TCP_Byte_Stream;

import java.io.*;
import java.net.*;

public class Cau9 {
    public static void main(String[] args) {
        String server = "test"; // Thay bằng IP/Domain server phòng thi
        int port = 806;
        String name = "B23DCCN686";
        String qcode = "D45EFA12";

        try (Socket socket = new Socket(server, port)) {
            socket.setSoTimeout(5000);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // a. Gửi mã sinh viên và mã câu hỏi
            String request = name + ";" + qcode;
            out.write(request.getBytes());
            out.flush();

            // b. Nhận chuỗi số nguyên từ server
            byte[] buffer = new byte[4096];
            int byteRead = in.read(buffer);
            if (byteRead <= 0) return;

            String response = new String(buffer, 0, byteRead).trim();
            String[] list = response.split(",");
            int n = list.length;
            int[] nums = new int[n];
            double sum = 0;

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(list[i].trim());
                sum += nums[i];
            }
            double avg = sum / n;
            int num1 = nums[0];
            int num2 = nums[1];
            double minDiff = Double.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double pairSum = nums[i] + nums[j];
                    double diff = Math.abs(pairSum - avg);

                    if (diff < minDiff) {
                        minDiff = diff;
                        num1 = nums[i];
                        num2 = nums[j];
                    }
                }
            }
            String result = num1 + "," + num2;
            out.write(result.getBytes());
            out.flush();

            // d. Kết nối tự đóng khi kết thúc khối try-with-resources
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}