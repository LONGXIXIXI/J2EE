package Network.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    //创建服务端Socket的API
    ServerSocket serverSocket = null;

    //构造方法
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }



    public void start() throws IOException {
        System.out.println("服务器已上线.....");

        ExecutorService service = Executors.newCachedThreadPool();

        //Tcp每次循环就是要处理一个连接，一个连接里可能会有多组请求和响应
        while(true){
            Socket socket = serverSocket.accept();

            service.submit(() -> {
               processConnection(socket);
            });
        }

    }



    private void processConnection(Socket socket)  {
        System.out.printf("[%s,%d] 客户端上线\n",socket.getInetAddress().toString(),socket.getPort());

        try (InputStream inputStream = socket.getInputStream() ;
             OutputStream outputStream = socket.getOutputStream()){

            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            //一个连接中可能会涉及到多组请求/响应的交互
            while(true){
                //一次循环就是处理一组请求和响应
                if (!scanner.hasNext()){
                    //判断当前tcp连接是否断开了
                    break;
                }

                //1.读取请求并解析
                String request = scanner.next();

                //2.根据请求计算响应
                String response = process(request);

                //3.把响应写回给客户端
                printWriter.println(response);
                printWriter.flush();


                //4.打印日志
                System.out.printf("[%s,%d]: req: %s; res: %s\n",socket.getInetAddress().toString(),socket.getPort(),request,response);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                System.out.printf("[%s,%d] 客户端下线！\n",socket.getInetAddress().toString(),socket.getPort());
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    private String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
