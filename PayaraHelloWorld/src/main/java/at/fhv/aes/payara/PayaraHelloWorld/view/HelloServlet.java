package at.fhv.aes.payara.PayaraHelloWorld.view;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World2!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css\" rel=\"stylesheet\">\n" +
                "<script src=\"setcookie.js\"></script>" +
                "</head>\n" +
                "<body onload=\"setCookie()\">\n" +
                "\n" +
                "<!-- comment form -->\n" +
                "    <div class=\"flex mx-auto items-center justify-center shadow-lg mt-24 mx-8 mb-4 max-w-lg\">\n" +
                "        <form action=\"add-comment-servlet\" method=\"post\" class=\"w-full max-w-xl bg-white rounded-lg px-4 pt-2\">\n" +
                "            <div class=\"flex flex-wrap -mx-3 mb-6\">\n" +
                "                <h2 class=\"px-4 pt-3 pb-2 text-gray-800 text-lg\">Add a new comment</h2>\n" +
                "                <div class=\"w-full md:w-full px-3 mb-2 mt-2\">\n" +
                "                    <textarea class=\"bg-gray-100 rounded border border-gray-400 leading-normal resize-none w-full h-20 py-2 px-3 font-medium placeholder-gray-700 focus:outline-none focus:bg-white\" name=\"message\" placeholder='Type Your Comment' required></textarea>\n" +
                "                </div>\n" +
                "                <div class=\"w-full md:w-full px-3 mb-2 mt-2\">\n" +
                "                    <input class=\"bg-gray-100 rounded border border-gray-400 leading-normal resize-none w-full  py-2 px-3 font-medium placeholder-gray-700 focus:outline-none focus:bg-white\" name=\"author\" placeholder='Type your name' required></input>\n" +
                "                </div>\n" +
                "                <div class=\"w-full md:w-full px-3 mb-2\">\n" +
                "                    <input class=\"bg-gray-100 rounded border border-gray-400 leading-normal resize-none w-full  py-2 px-3 font-medium placeholder-gray-700 focus:outline-none focus:bg-white\" name=\"email\" placeholder='Type your email' required></input>\n" +
                "                </div>\n" +
                "                <div class=\"w-full md:w-full flex items-start md:w-full px-3\">\n" +
                "                    <div class=\"flex items-start w-1/2 text-gray-700 px-2 mr-auto\">\n" +
                "                        <svg fill=\"none\" class=\"w-5 h-5 text-gray-600 mr-1\" viewBox=\"0 0 24 24\" stroke=\"currentColor\">\n" +
                "                            <path stroke-linecap=\"round\" stroke-linejoin=\"round\" stroke-width=\"2\" d=\"M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z\"/>\n" +
                "                        </svg>\n" +
                "                        <p class=\"text-xs md:text-sm pt-px\">Leave a message :)</p>\n" +
                "                    </div>\n" +
                "                    <div class=\"-mr-1\">\n" +
                "                        <input type='submit' class=\"bg-white text-gray-700 font-medium py-1 px-4 border border-gray-400 rounded-lg tracking-wide mr-1 hover:bg-gray-100\" value='Post Comment'>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
}