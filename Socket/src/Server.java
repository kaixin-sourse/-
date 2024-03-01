import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)) {
            while(true) {
                System.out.println("等待客户端连接...");
                Socket socket = server.accept();
                //设置socket的缓冲区大小，涉及底层，但是平常用不到。
                socket.setReceiveBufferSize(25565);
                socket.setSendBufferSize(25565);
                System.out.println("客户端连接成功!IP地址为:" + socket.getInetAddress().getHostAddress());
                socket.setSoTimeout(3000);
                //接收客户端发来的数据
                BufferedReader reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());

                //返回数据给客户端
                OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                writer.write("收到\n");
                writer.flush();
                socket.close(); //这个是因为上面的socket实在代码块中写的，而不是try()catch()中写的
            }
        }catch(IOException e ) {
            e.printStackTrace();
        }
    }
}
