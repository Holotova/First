package servlets;

import fourthModule.model.Factory;
import fourthModule.util.HibernateFactoryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "StartProduction", value = "/race/start")
public class StartProduction extends HttpServlet {

    private static final Factory FACTORY = new Factory();

    @Override
    public void init() {
        System.out.println(getServletName() + " initialized");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        HibernateFactoryUtil.init();
        try {
            FACTORY.startProduction();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.println("Detail is Ready!");
        } finally {
            writer.close();
        }

    }

    @Override
    public void destroy() {
        System.out.println(getServletName() + " destroyed");
    }
}
