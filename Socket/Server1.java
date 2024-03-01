import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)) {
            Socket socket = server.accept();
            InputStream stream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("net/Server.java");
            byte[] bytes = new byte[1024];
            int i;
            while((i = stream.read(bytes)) != -1) {
                fileOutputStream.write(bytes,0,i);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            stream.close();

        } catch(IOException e) {
               e.printStackTrace();
        }
    }
}
