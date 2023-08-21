package yy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReadCardBas {
    public static void ReadCardBas_HSM_Step1() throws IOException {
//        读基本信息
        Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("连接服务端成功！");
        String sss = "{\"command\": \"ReadCardBas_HSM_Step1\", \"param\": {\"iType\": 1}}";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(sss.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = new byte[1024];
        // 读一下服务端发来的信息
        InputStream inputStream = socket.getInputStream();
        int read = inputStream.read(bytes);
        System.out.println("服务端：" + new String(bytes, 0, read, Charset.defaultCharset()));
//
    }
    public static void ReadCardBas_HSM_Step2() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("连接服务端成功！");
        String sss = "{\"command\": \"ReadCardBas_HSM_Step2\", \"param\": {\"iType\": 1}}";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(sss.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = new byte[1024];
        // 读一下服务端发来的信息
        InputStream inputStream = socket.getInputStream();
        int read = inputStream.read(bytes);
        System.out.println("服务端：" + new String(bytes, 0, read, Charset.defaultCharset()));
    }

    public static void main(String[] args) throws IOException {
        ReadCardBas.ReadCardBas_HSM_Step1();
    }


}
