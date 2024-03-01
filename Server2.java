import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)) {
            System.out.println("等待客户端响应!");
            Socket socket = server.accept();
            System.out.println("客户端已连接,IP地址为:" + socket.getInetAddress().getHostAddress());
            InputStream in = socket.getInputStream();
            System.out.println("接收到客户端数据");
            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1,1 200 Accepted\r\n");
            writer.write("\r\n");
            writer.write("lbwnb!");
            writer.flush();
            socket.close();
            //int i;
            //while((i = in.read()) != -1) {
            //    System.out.print((char)i);
            //}
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
