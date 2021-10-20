package at.fhv.ae.webserver;

/*
    Autor: Adrian Essig
    Date: 20.10.2021
    Title: Webserver
    Sources:https://dev.to/mateuszjarzyna/build-your-own-http-server-in-java-in-less-than-one-hour-only-get-method-2k02
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

    public static void main(String[] args) throws IOException {



        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started.\nListening for connections on port : 8080 ...\n");
            while (true) {

                    Socket client = serverSocket.accept();
                    System.out.println("Debug: got new client " + client.toString());

                    //HTTPWebServer webServer = new HTTPWebServer(client);
                    new Thread(new HTTPWebServer(client)).start();



            }

        } catch(IOException e) {
        System.out.println("Error starting the server: " + e.getMessage());
        System.exit(1);
    }

    }

}
