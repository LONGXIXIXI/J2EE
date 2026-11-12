package Network.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //先创建socket对象
    private DatagramSocket socket = null;

    //构造方法
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        //启动服务器
        System.out.println("服务器启动......");

        //服务器需要不断的处理客户端发来的请求
        while(true){
            //循环一次就是处理一个请求

            //1.读取请求并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);

            //为了处理请求方便，把里面的载荷数据获取出来，构造成一个String
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());

            //2.根据请求构造响应
            String response = process(request);

            //3.把响应返回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,requestPacket.getSocketAddress());
            socket.send(responsePacket);
            //4.打印日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n",requestPacket.getAddress().toString(),responsePacket.getPort(),request,response);
        }

    }

    //此处是回显服务器，响应和请求完全一样
    public String process(String request){
        return request;
    }

    public static void main(String[] args) throws IOException {
        //端口号是一个整数，可以随意指定
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }


}
