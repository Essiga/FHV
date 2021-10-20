package at.fhv.ae.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HTTPWebServer implements Runnable{
    private final Socket client;

    public HTTPWebServer(Socket client){
        this.client = client;

    }

    private void handleClient() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line + "\r\n");
        }

        String request = requestBuilder.toString();
        try {

            String[] requestsLines = request.split("\r\n");
            String[] requestLine = requestsLines[0].split(" ");
            String method = requestLine[0];
            String path = requestLine[1];
            String version = requestLine[2];
            String host = requestsLines[1].split(" ")[1];

            List<String> headers = new ArrayList<>();
            //header starts from third line of the request
            for (int i = 2; i < requestsLines.length; i++) {
                String header = requestsLines[i];
                headers.add(header);
            }

            String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s, headers %s",
                    client.toString(), method, path, version, host, headers.toString());
            System.out.println(accessLog);

            Path filePath = getFilePath(path);
            if (Files.exists(filePath)) {

                String contentType = guessContentType(filePath);
                sendResponse(client, version, "200 OK", contentType, Files.readAllBytes(filePath));
            } else {

                byte[] notFoundContent = "<html><img src=\"https://assets.codepen.io/2725180/internal/screenshots/pens/KbqmmV.default.png?fit=cover&format=auto&ha=false&height=540&quality=75&v=2&version=1545746147&width=960\"/></html>".getBytes();
                sendResponse(client, version, "404 Not Found", "text/html", notFoundContent);
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            sendResponse(client, "HTTP/1.1", "500 internal error", "", "".getBytes());
        }

    }
    public void sendResponse(Socket client, String version, String status, String contentType, byte[] content) throws IOException {


        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write((version + " "  + status +"\r\n").getBytes());
        clientOutput.write((("ContentType: " + contentType + "\r\n")).getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content);
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

    private String guessContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }

    private Path getFilePath(String path) {
        if ("/".equals(path)) {
            path = "webroot\\index.html";
        }
        else {
            path = "webroot" + path.replaceAll("/", "\\\\");
        }

        return Paths.get(path);
    }

    @Override
    public void run() {
        try {
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
