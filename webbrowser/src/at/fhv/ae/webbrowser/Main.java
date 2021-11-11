/*
    Author: Adrian Essig
    Title: Webbrowser
    Date: 14/10/2021

 */

package at.fhv.ae.webbrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String url = getUrlFromUser();

        String domain = "";
        String path = "";
        URLTokenizer urlTokenizer = new URLTokenizer(url);
        domain = urlTokenizer.getDomain();
        path = urlTokenizer.getPath();

        Socket socket = new Socket(domain, 80);

        BufferedReader response = sendGETRequest(socket, domain, path);

        printResponse(response);

        socket.close();

    }

    public static BufferedReader sendGETRequest(Socket socket, String domain, String path) throws IOException {
        InetAddress inetAddress = socket.getInetAddress();
        String ipAddress = inetAddress.toString().split("/")[1];
        System.out.println("Connecting to Server " + domain + " at " + ipAddress);

        PrintWriter socketOutputStreamWriter = new PrintWriter(socket.getOutputStream());


        socketOutputStreamWriter.println("GET /" + path + " HTTP/1.0");
        socketOutputStreamWriter.println("Host: " + domain);
        socketOutputStreamWriter.println("");
        socketOutputStreamWriter.flush();

        BufferedReader response = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        return response;

    }

    public static String getUrlFromUser() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the website: ");
        String url = userInput.nextLine();
        return url;
    }
//response.forEach(system.out::println)
    public static void printResponse(BufferedReader bufferedInputStream) throws IOException {
        String socketResponse;

        while ((socketResponse = bufferedInputStream.readLine()) != null) {
            if (socketResponse.split(" ")[1].equals("200")) {
                while (!socketResponse.equals("")) {
                    socketResponse = bufferedInputStream.readLine();
                }
            }
            while ((socketResponse != null)) {
                System.out.println(socketResponse);
                socketResponse = bufferedInputStream.readLine();
            }
        }

        bufferedInputStream.close();
    }
}
