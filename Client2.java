import java.io.*;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8081)) {

            FileInputStream fileInputStream= new FileInputStream("Server.java");
            //为什么没有写writer呢，是因为可能需要传输的文件不一定是字节流，有可能是视频那种
            OutputStream stream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            int i;
            while((i = fileInputStream.read(bytes)) != -1) {
                stream.write(bytes,0,i);
            }
            stream.flush();
            fileInputStream.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
