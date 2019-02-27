package com.itlbv.routines.web;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/routines", name = "routinesServlet")
public class RoutineServlet extends HttpServlet {

    private RoutineRestController controller;
    private ConfigurableApplicationContext springCtx;

    @Override
    public void init() throws ServletException {
        super.init();
        springCtx = new ClassPathXmlApplicationContext("/spring/spring-app.xml");
        controller = springCtx.getBean(RoutineRestController.class);
    }

    @Override
    public void destroy() {
        super.destroy();
        springCtx.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "getAll" : action) {
            case "update":
                break;
            case "delete":
                break;
            default:
                req.setAttribute("routines",
                        controller.getAll());
                req.getRequestDispatcher("/routinesServlet.jsp").forward(req, resp);
                break;
        }
    }
}
