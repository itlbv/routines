package com.itlbv.routines.web;

import com.itlbv.routines.model.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/users", name = "usersServlet")
public class UserServlet extends HttpServlet {

    private UserRestController controller;
    private ConfigurableApplicationContext springCtx;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springCtx = new ClassPathXmlApplicationContext("/spring/spring-app.xml", "/spring/spring-db.xml");
        controller = springCtx.getBean(UserRestController.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action == null ? "getAll" : action) {
            case "create":
            case "update":
                User user = action.equals("create") ?
                        new User("", "", "", null) :
                        controller.get(getId(req));
                req.setAttribute("user", user);
                req.getRequestDispatcher("/userForm.jsp").forward(req, resp);
                break;
            case "delete":
                controller.delete(getId(req));
                resp.sendRedirect("users");
                break;
            case "getAll":
            default:
                req.setAttribute("users",
                        controller.getAll());
                req.getRequestDispatcher("/users.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private int getId(HttpServletRequest req) {
        String stringId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.parseInt(stringId);
    }
}
