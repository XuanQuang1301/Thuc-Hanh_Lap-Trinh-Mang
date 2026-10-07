package TCP;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class QlDTaUsf {
    private static final String SERVER_HOST = "36.50.135.242";
    private static final int SERVER_PORT = 2210;

    // Gửi dữ liệu nén qua GZIP
    private static void sendZip(OutputStream out, String msg) throws IOException {
        GZIPOutputStream gOut = new GZIPOutputStream(out);
        gOut.write(msg.getBytes(StandardCharsets.UTF_8));
        gOut.finish();
        out.flush();
    }

    // Đọc payload GZIP từ server vào buffer byte rồi giải nén
    private static String readZip(InputStream in) throws IOException {
        // Đọc dữ liệu thô mà server gửi về
        ByteArrayOutputStream rawBuffer = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        
        // Đợi có dữ liệu đầu tiên
        int bytesRead = in.read(temp);
        if (bytesRead != -1) {
            rawBuffer.write(temp, 0, bytesRead);
        }
        
        // Đọc tiếp phần còn lại nếu còn dữ liệu sẵn trong socket buffer
        while (in.available() > 0) {
            int len = in.read(temp);
            if (len != -1) {
                rawBuffer.write(temp, 0, len);
            }
        }

        // Giải nén mảng byte nhận được từ GZIP
        try (GZIPInputStream gIn = new GZIPInputStream(new ByteArrayInputStream(rawBuffer.toByteArray()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(gIn, StandardCharsets.UTF_8))) {
            return reader.readLine();
        }
    }

    public static void main(String[] args) {
        String studentCode = "B23DCCN686";
        String qCode = "QlDTaUsf";

        try (Socket socket = new Socket(SERVER_HOST, SERVER_PORT)) {
            socket.setSoTimeout(5000);

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // 1. Gửi request kèm \n
            String request = studentCode + ";" + qCode + "\n";
            sendZip(out, request);

            // 2. Đọc chuỗi sau khi giải nén
            String response = readZip(in);
            if (response == null) {
                return;
            }
            
            // Xóa ký tự \r nếu có ở cuối chuỗi đọc được từ readLine()
            if (response.endsWith("\r")) {
                response = response.substring(0, response.length() - 1);
            }

            // 3. Đảo ngược chuỗi (giữ nguyên khoảng trắng nếu có)
            String reversed = new StringBuilder(response).reverse().toString();

            // 4. Mã hóa Base64 chuỗi đã đảo ngược
            String base64Str = Base64.getEncoder().encodeToString(reversed.getBytes(StandardCharsets.UTF_8));

            // 5. Gửi chuỗi kết quả: <reversed_string>|<base64_string>\n
            String result = reversed + "|" + base64Str + "\n";
            sendZip(out, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}