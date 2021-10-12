package at.fhv.ae.webbrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner userInput = new Scanner(System.in);
        System.out.print("Please enter the website: ");
        String domain = userInput.nextLine();


        Socket socket = new Socket(domain, 80);

        PrintWriter socketOutputStreamWriter = new PrintWriter(socket.getOutputStream());

        //Prints the request string to the output stream
        socketOutputStreamWriter.println("GET / HTTP/1.0");
        socketOutputStreamWriter.println("Host: "+ domain);
        socketOutputStreamWriter.println("");
        socketOutputStreamWriter.flush();

        BufferedReader bufRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String outStr;

        //Prints each line of the response
        while((outStr = bufRead.readLine()) != null){
            System.out.println(outStr);
        }


        //Closes out buffer and writer
        bufRead.close();
        socketOutputStreamWriter.close();

    }
}
