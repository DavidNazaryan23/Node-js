package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HTTPServer {

    public static URL myURL;
    private AsynchronousServerSocketChannel server;
    private final static String HEADERS =
                            "HTTP/1.1 200 OK\n" +
                            "Server: dav\n"+
                            "Content-Type: text/html\n"+
                            "Content-Length: %s\n" +
                            "Connection: close\n\n";

    static {
        try {
            myURL = new URL("http://127.0.0.1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public void startServer(){
        try {
            server = AsynchronousServerSocketChannel.open();
            server.bind(new InetSocketAddress("127.0.0.1", 80));

            System.out.println("connected");


            while (true){
                Future<AsynchronousSocketChannel> accept = server.accept();
                handleClient(accept);
            }



        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void handleClient(Future<AsynchronousSocketChannel> accept) throws ExecutionException, InterruptedException, IOException {


        AsynchronousSocketChannel client = accept.get();


        while (client !=null && client.isOpen()){

            ByteBuffer buffer = ByteBuffer.allocate(256);

            StringBuilder builder = new StringBuilder();
            boolean canRead = true;

            while (canRead){

                client.read(buffer).get();

                int position = buffer.position();
                canRead = position == 256;


                byte[] array = canRead? buffer.array(): Arrays.copyOfRange(buffer.array(),0,position);

                builder.append(new String(array));

                buffer.clear();



            }

            System.out.println(builder);

            String body = "<html><body><h1>Hello World</h1></body></html>";
            String page = String.format(HEADERS, body.length())+body;
            ByteBuffer resp = ByteBuffer.wrap(page.getBytes());

            client.write(resp);


            client.close();
        }
    }

}
