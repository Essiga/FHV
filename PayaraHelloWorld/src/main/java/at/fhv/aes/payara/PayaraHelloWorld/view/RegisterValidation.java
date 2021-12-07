package at.fhv.aes.payara.PayaraHelloWorld.view;

import at.fhv.aes.payara.PayaraHelloWorld.application.UserServiceImpl;
import at.fhv.aes.payara.PayaraHelloWorld.application.api.UserService;
import at.fhv.aes.payara.PayaraHelloWorld.domain.User;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerValidationServlet", value = "/register-validation-servlet")
public class RegisterValidation extends HttpServlet {


    private UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ServletContext application = getServletContext();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String userId = req.getParameter("userName");
        String password = req.getParameter("password");

        if(!userService.isPresent(userId)){
            User user = new User(firstName, lastName, userId, password);
            userService.saveToDatabase(user);

//            req.setAttribute("userID", test);
//            res.sendRedirect("registrationSuccess.jsp");
            req.setAttribute("userID", user.getUserID());
            //application.setAttribute("userID", test);
            application.getRequestDispatcher("/registrationSuccess.jsp").forward(req, res);

        }



        else{
            req.setAttribute("userID", userId);
            application.getRequestDispatcher("/register.jsp").forward(req, res);
        }


    }
}
