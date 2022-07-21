package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static fourthModule.service.DetailProduction.DETAIL_DAO;

@WebServlet(name = "GeneralStatistics", value = "/statistics")
public class GeneralStatisticsServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html");
        writer.println("<h1 align=\"center\">GENERAL INFORMATION</h1>");
        int details = DETAIL_DAO.getSumOfDetails();
        int brokenChips = DETAIL_DAO.getBrokenDetails();
        int fuel = DETAIL_DAO.getFuel();

        writer.println(String.format("<h2 align=\"center\">Details produced: %d </h2>", details));
        writer.println("<h2 align=\"center\">Broken Chips: " + brokenChips + "</h2>");
        writer.println("<h2 align=\"center\">Fuel produced: " + fuel + "</h2>");
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
