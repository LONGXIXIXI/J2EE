package Network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //创建客户端Socket
    Socket socket = null;

    //构造方法，指定需连接的服务器的IP和端口
    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp, serverPort);
    }

    public void start(){
        System.out.println("客户端启动.....");

        try(InputStream inputStream = socket.getInputStream() ;
            OutputStream outputStream = socket.getOutputStream()) {
            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while(true){
                //1.从控制台读取用户输入
                System.out.print("->");
                String request = scannerConsole.next();


                //2.构造请求，发送给服务器
                printWriter.println(request);
                printWriter.flush();


                //3.从服务器读取响应
                if(!scannerNetwork.hasNext()){
                    break;
                }
                String response = scannerNetwork.next();


                //4.把响应显示到控制台上
                System.out.println(response);
            }

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }


}
