package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "PersonalServlet", value = "/PersonalServlet")
public class PersonalServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println("<h1 align=\"center\">USER INFORMATION</h1>");
        Date timeNow = new Date();
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        writer.println(String.format("<h1 align=\"center\">Current time: %s </h1>", formatTime.format(timeNow)));
        String ip = req.getRemoteHost();
        writer.println("<h3 align=\"center\">IP: " + ip + "</h3>");
        String userAgent = req.getHeader("User-Agent");
        writer.println("<h3 align=\"center\">User-Agent: " + userAgent + "</h3>");
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
