//package com.company;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class HTTPRequest {
//
//    private final static String LINE_BREAK = "\\r?\\n";
//
//    public enum HTTPMethod{
//        GET,POST,PUT,DELETE;
//
//
//        public static HTTPMethod findMethodFromString(String s){
//            for(HTTPMethod n: values()){
//                if(n.toString().equals(s)){
//                    return n;
//                }
//            }
//            return null;
//        }
//
//    }
//
//    private String message;
//    private HTTPMethod method;
//    private URL path;
//    private String protocol;
//    private Map<String,String> headers;
//    private String body;
//
//
//    public HTTPRequest(String message)  {
//        this.message = message;
//
//        String[] allLines = message.split(LINE_BREAK);
//
//        int emptyLine = -1;
//
//        for (int i = 0; i< allLines.length;i++){
//            if(allLines[i].trim().equals("")){
//                emptyLine = i;
//                break;
//            }
//        }
//
//        String[] headerLines = new String[emptyLine];
//        for (int i=0; i<emptyLine;i++){
//            headerLines[i] = allLines[i];
//        }
//        String[] firstLine = headerLines[0].split(" ");
//
//        //Getting the method
//        this.method = HTTPMethod.findMethodFromString(firstLine[0]);
////        System.out.println(this.method);
//
//        //Getting the URL
//        try {
////            System.out.println(firstLine[1]);
//            this.path = new URL(HTTPServer.myURL, firstLine[1]);
//        } catch (MalformedURLException ex){
//            System.out.println("ERROR");
//        }
//
////        System.out.println(path);
//
//        //Getting the protocol
//        this.protocol = firstLine[2];
////        System.out.println(this.protocol);
//
//        //Getting the headers
//        this.headers = new LinkedHashMap<>();
//        for(int i = 1; i<headerLines.length; i++){
//            String currHeader = headerLines[i];
//            int separation = currHeader.indexOf(':');
//            String key = currHeader.substring(0,separation);
////            System.out.println(key);
//            String value = currHeader.substring(separation+2);
////            System.out.println(value);
//            this.headers.put(key,value);
//        }
//
//
//        //Getting the body
//        StringBuilder builder = new StringBuilder();
//        for (int i = emptyLine+1; i<allLines.length; i++){
//            builder.append(allLines[i]);
//        }
//        this.body = builder.toString();
////        System.out.println(body);
//
//
//    }
//
//    public HTTPMethod getMethod() {
//        return method;
//    }
//
//    public URL getPath() {
//        try {
//            return new URL(this.path.toString());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public String getProtocol() {
//        return protocol;
//    }
//
//    public Map<String, String> getHeaders() {
//        return new LinkedHashMap<>(this.headers);
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public String toString(){
//
//        return message;
//    }
//
//
//
//
//
//
//}
