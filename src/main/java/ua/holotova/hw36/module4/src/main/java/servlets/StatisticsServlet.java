package servlets;

import fourthModule.model.Detail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static fourthModule.service.DetailProduction.DETAIL_DAO;

@WebServlet(name = "Statistics", value = "/stats")
public class StatisticsServlet extends HttpServlet {
    private static List<Detail> DETAILS = new ArrayList<>();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        DETAILS = DETAIL_DAO.getAll();
        req.setAttribute("detailList", DETAILS);
        req.getRequestDispatcher("detailList.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
