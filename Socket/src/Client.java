import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8081);
            Scanner scanner = new Scanner(System.in)) {
            System.out.println("已连接服务器");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write(scanner.nextLine() + "\n");
            writer.flush();
            System.out.println("数据已发送！等待服务端确认...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("收到服务端响应：" + reader.readLine());
        } catch (IOException e) {
            System.out.println("连接失败!");
            e.printStackTrace();
        }
    }
}
