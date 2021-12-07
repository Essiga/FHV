package at.fhv.aes.payara.PayaraHelloWorld.view;

import at.fhv.aes.payara.PayaraHelloWorld.application.CommentServiceImpl;
import at.fhv.aes.payara.PayaraHelloWorld.application.api.CommentService;
import at.fhv.aes.payara.PayaraHelloWorld.application.dto.CommentDTO;
import at.fhv.aes.payara.PayaraHelloWorld.domain.Comment;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.CommentRepository;
import at.fhv.aes.payara.PayaraHelloWorld.infrastructure.CommentRepositoryImpl;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "addCommentServlet", value = "/add-comment-servlet")
public class AddCommentServlet extends HttpServlet {
    private String message;
    private CommentService commentService = new CommentServiceImpl(new CommentRepositoryImpl());

    public void init() {
        message = "Hello World2!";
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Comment comment = new Comment(req.getParameter("message"), req.getParameter("author"), req.getParameter("email"));
        commentService.saveToDatabase(comment);

        res.setContentType("text/html");
        List<CommentDTO> comments = commentService.getAllComments();
        // Hello
        PrintWriter out = res.getWriter();
        out.println("");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css\" rel=\"stylesheet\">\n" +
                "<script src=\"setcookie.js\"></script>"+
                "</head><body onload=\"setCookie()\">\n"+
                "<nav class=\"bg-green-400 shadow-lg\">\n" +
                "    <div class=\"max-w-6xl px-4\">\n" +
                "        <div class=\"flex justify-between\">\n" +
                "            <div class=\"flex space-x-7\">\n" +
                "                <!-- Website Logo -->\n" +
                "                <div>\n" +
                "                    <a href=\"/index.html\" class=\"flex items-center py-4 px-2\">\n" +
                "                        <img src=\"/pictures/logo.png\" alt=\"Logo\" class=\"h-8 w-8 mr-2\" />\n" +
                "                        <span class=\"font-semibold text-gray-500 text-lg\">Navigation</span>\n" +
                "                    </a>\n" +
                "                </div>\n" +
                "                <!-- Primary Navbar items -->\n" +
                "                <div class=\"flex items-center space-x-1\">\n" +
                "                    <a href=\"/index.html\" class=\"py-4 px-2 text-gray-100 font-semibold \">Home</a>\n" +
                "                    <a href=\"/paintball.html\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\">Paintball</a>\n" +
                "                    <a href=\"/schach.jsp\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\">Chess</a>\n" +
                "                </div>\n" +
                "                <div class=\"flex items-center space-x-1\">\n" +
                "                    <a href=\"mailto:aes6270@students.fhv.at\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\"><img class=\"h-8 w-8 mr-2\" src=\"/pictures/email.png\" alt=\"email icon\"></a>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</nav>" +
                "<div class=\"flex grid grid-cols-3 items-center justify-center shadow-lg mt-24 mx-8 mb-4 \">\n");

        for (CommentDTO c: comments) {
            out.println("<div><div class=\"max-w-md py-4 px-8 bg-white shadow-lg rounded-lg my-6 ml-auto mr-auto\">\n" +
                    "        <div>\n" +
                    "            <h2 class=\"text-gray-800 text-3xl font-semibold\">" + c.getAuthor() + "</h2>\n" +
                    "            <p class=\"mt-2 text-gray-600\">" + c.getMessage() + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"flex justify-end mt-4\">\n" +
                    "            <a href=\"#\" class=\"text-xl font-medium text-indigo-500\">" + c.getEmail() + "</a>\n" +
                    "        </div>\n" +
                    "    </div></div>");
        }


        out.println("</div><!-- comment form -->\n" +
                "    <div class=\"flex mx-auto items-center justify-center shadow-lg mt-12 mx-8 mb-4 max-w-lg\">\n" +
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
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Comment comment = new Comment(req.getParameter("message"), req.getParameter("author"), req.getParameter("email"));

        res.setContentType("text/html");
        List<CommentDTO> comments = commentService.getAllComments();
        // Hello
        PrintWriter out = res.getWriter();
        out.println("");
        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css\" rel=\"stylesheet\">\n" +
                "</head><body>\n"+
                "<nav class=\"bg-green-400 shadow-lg\">\n" +
                "    <div class=\"max-w-6xl px-4\">\n" +
                "        <div class=\"flex justify-between\">\n" +
                "            <div class=\"flex space-x-7\">\n" +
                "                <!-- Website Logo -->\n" +
                "                <div>\n" +
                "                    <a href=\"/PayaraHelloWorld-1.0-SNAPSHOT/index.html\" class=\"flex items-center py-4 px-2\">\n" +
                "                        <img src=\"/PayaraHelloWorld-1.0-SNAPSHOT/pictures/logo.png\" alt=\"Logo\" class=\"h-8 w-8 mr-2\" />\n" +
                "                        <span class=\"font-semibold text-gray-500 text-lg\">Navigation</span>\n" +
                "                    </a>\n" +
                "                </div>\n" +
                "                <!-- Primary Navbar items -->\n" +
                "                <div class=\"flex items-center space-x-1\">\n" +
                "                    <a href=\"/PayaraHelloWorld-1.0-SNAPSHOT/index.html\" class=\"py-4 px-2 text-gray-100 font-semibold \">Home</a>\n" +
                "                    <a href=\"/PayaraHelloWorld-1.0-SNAPSHOT/paintball.html\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\">Paintball</a>\n" +
                "                    <a href=\"/PayaraHelloWorld-1.0-SNAPSHOT/schach.jsp\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\">Chess</a>\n" +
                "                </div>\n" +
                "                <div class=\"flex items-center space-x-1\">\n" +
                "                    <a href=\"mailto:aes6270@students.fhv.at\"\n" +
                "                       class=\"py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300\"><img class=\"h-8 w-8 mr-2\" src=\"/PayaraHelloWorld-1.0-SNAPSHOT/pictures/email.png\" alt=\"email icon\"></a>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</nav>" +
                "<div class=\"flex grid grid-cols-3 items-center justify-center shadow-lg mt-6 mx-8 mb-4 \">\n");

        for (CommentDTO c: comments) {
            out.println("<div><div class=\"max-w-md py-4 px-8 bg-white shadow-lg rounded-lg my-6 ml-auto mr-auto\">\n" +
                    "        <div>\n" +
                    "            <h2 class=\"text-gray-800 text-3xl font-semibold\">" + c.getAuthor() + "</h2>\n" +
                    "            <p class=\"mt-2 text-gray-600\">" + c.getMessage() + "</p>\n" +
                    "        </div>\n" +
                    "        <div class=\"flex justify-end mt-4\">\n" +
                    "            <a href=\"#\" class=\"text-xl font-medium text-indigo-500\">" + c.getEmail() + "</a>\n" +
                    "        </div>\n" +
                    "    </div></div>");
        }


        out.println("</div><!-- comment form -->\n" +
                "    <div class=\"flex mx-auto items-center justify-center shadow-lg mt-12 mx-8 mb-4 max-w-lg\">\n" +
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
    }

    public void destroy() {
    }
}