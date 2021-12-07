package at.fhv.aes.payara.PayaraHelloWorld.view;

import at.fhv.aes.payara.PayaraHelloWorld.application.UserServiceImpl;
import at.fhv.aes.payara.PayaraHelloWorld.application.api.UserService;
import at.fhv.aes.payara.PayaraHelloWorld.domain.User;
import at.fhv.aes.payara.PayaraHelloWorld.domain.UserNotFoundException;
import at.fhv.aes.payara.PayaraHelloWorld.domain.api.UserRepository;
import at.fhv.aes.payara.PayaraHelloWorld.infrastructure.UserRepositoryImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "verifyLoginServlet", value = "/verify-login-servlet")
public class VerifyLogin extends HttpServlet {

    private UserService userService = new UserServiceImpl(new UserRepositoryImpl());

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext application = getServletContext();

        String userId = req.getParameter("userName");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        if(userService.isPresent(userId)){
           Optional<User> userOpt = userService.findById(userId);
           if(userOpt.isPresent()){
               User user = userOpt.get();

               if(user.verifyPassword(password)) {

                   session.setAttribute("isLoggedIn", true);

                   String originalDestination = (String) session.getAttribute("originalDestination");

                   //application.getRequestDispatcher(originalDestination).forward(req, res);
                   res.sendRedirect(originalDestination);
               }
               else {
                   session.setAttribute("isLoggedIn", false);

                   application.getRequestDispatcher("/login.jsp").forward(req, res);
               }
           }
           else {
               try {
                   throw new UserNotFoundException("User with username: " + userId + " not found.");
               } catch (UserNotFoundException e) {
                   session.setAttribute("isLoggedIn", false);

                   application.getRequestDispatcher("/login.jsp").forward(req, res);

               }
           }
        }      else {
            try {
                throw new UserNotFoundException("User with username: " + userId + " not found.");
            } catch (UserNotFoundException e) {
                session.setAttribute("isLoggedIn", false);

                application.getRequestDispatcher("/login.jsp").forward(req, res);

            }
        }

    }

}
