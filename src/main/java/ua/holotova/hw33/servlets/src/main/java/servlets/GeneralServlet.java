package servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "GeneralServlet", value = "/GeneralServlet")
public class GeneralServlet extends HttpServlet {
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        PrintWriter responseBody = resp.getWriter();
        resp.setContentType("text/html");
        responseBody.println("<h1 align=\"center\">USERS INFORMATION</h1>");
        Date timeNow = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        String ip = req.getRemoteHost();
        String userAgent = req.getHeader("User-Agent");
        User user = new User(formatTime.format(timeNow), ip, userAgent);
        USERS.add(user);
        req.setAttribute("usersList", USERS);
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
