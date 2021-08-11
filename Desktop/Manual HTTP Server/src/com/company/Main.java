package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here



//
//        HTTPRequest request = new HTTPRequest("POST /api/authors HTTP/1.1\n" +
//                "Host: myWebApi.com\n" +
//                "Content-Type: application/json\n" +
//                "Cache-Control: no-cache\n" +
//                "\n" +
//                "{\n" +
//                "     \"Name\": \"Felipe Gavilán\",\n" +
//                "     \"Age\": 999\n" +
//                "}");



        HTTPServer server = new HTTPServer();
        server.startServer();

    }


}
