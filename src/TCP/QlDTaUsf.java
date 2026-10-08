import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class QlDTaUsf {
    private static final String SERVER_HOST = "localhost"; // Hoặc IP của server thi/chấm
    private static final int SERVER_PORT = 2210;
    private static final int TIMEOUT_MS = 5000;

    public static void main(String[] args) {
        String studentCode = "B16DCCN999";
        String qCode = "GZLEN01";

        try (Socket socket = new Socket()) {
            // Thiết lập timeout kết nối và đọc dữ liệu (5s)
            socket.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT), TIMEOUT_MS);
            socket.setSoTimeout(TIMEOUT_MS);

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // a. Gửi mã sinh viên và mã câu hỏi: studentCode;qCode\n
            String request = studentCode + ";" + qCode + "\n";
            sendGzipData(out, request);

            // b. Nhận dữ liệu từ server (đã nén gzip)
            String receivedData = readGzipData(in);
            if (receivedData != null) {
                // Cắt bỏ ký tự xuống dòng ở cuối (nếu có)
                receivedData = receivedData.trim();
            }

            // c. Đảo ngược chuỗi và encode Base64 chuỗi đảo ngược
            String reversed = new StringBuilder(receivedData).reverse().toString();
            String base64Encoded = Base64.getEncoder().encodeToString(reversed.getBytes(StandardCharsets.UTF_8));
            
            // Khuôn dạng: <reversed_string>|<base64_string>\n
            String resultMessage = reversed + "|" + base64Encoded + "\n";
            sendGzipData(out, resultMessage);

            // d. Đóng kết nối tự động kết thúc qua try-with-resources

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendGzipData(OutputStream out, String data) throws IOException {
        GZIPOutputStream gzipOut = new GZIPOutputStream(out);
        gzipOut.write(data.getBytes(StandardCharsets.UTF_8));
        gzipOut.finish(); // Hoàn thiện frame nén GZIP mà không đóng socket bên dưới
        gzipOut.flush();
    }

    private static String readGzipData(InputStream in) throws IOException {
        GZIPInputStream gzipIn = new GZIPInputStream(in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(gzipIn, StandardCharsets.UTF_8));
        return reader.readLine();
    }
}