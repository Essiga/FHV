package at.fhv.ae.webbrowser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the website: ");
        String domain = sc.nextLine();


        Socket s = new Socket(domain, 80);

        PrintWriter wtr = new PrintWriter(s.getOutputStream());

        //Prints the request string to the output stream
        wtr.println("GET / HTTP/1.0");
        wtr.println("Host: "+ domain);
        wtr.println("");
        wtr.flush();

        BufferedReader bufRead = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String outStr;

        //Prints each line of the response
        while((outStr = bufRead.readLine()) != null){
            System.out.println(outStr);
        }


        //Closes out buffer and writer
        bufRead.close();
        wtr.close();

    }
}
