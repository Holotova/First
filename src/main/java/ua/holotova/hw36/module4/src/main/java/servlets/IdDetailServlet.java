package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import static fourthModule.service.DetailProduction.DETAIL_DAO;

@WebServlet(name = "IdDetailServlet", value = "/detailId")
public class IdDetailServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));

        LocalDate date = DETAIL_DAO.getById(id).getDate();
        Long time = DETAIL_DAO.getById(id).getTimeForDetail();
        Integer fuel = DETAIL_DAO.getById(id).getFuel();
        Integer brokenChips = DETAIL_DAO.getById(id).getBrokenSchema();
        try {
            writer.println("<p>ID: " + id + "</p>");
            writer.println("<p>Production date: " + date + "</p>");
            writer.println("<p>Time for detail production: " + time + "</p>");
            writer.println("<p>Fuel produced: " + fuel + "</p>");
            writer.println("<p>Broken chips: " + brokenChips + "</p>");
        } finally {
            writer.close();
        }
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
