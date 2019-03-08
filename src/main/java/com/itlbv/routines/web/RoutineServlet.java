package com.itlbv.routines.web;

import com.itlbv.routines.model.Routine;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

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
            case "create":
            case "update":
                Routine routine = action.equals("create") ?
                        new Routine("", "",
                                LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES),
                                LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).plusYears(1),
                                LocalTime.now().truncatedTo(ChronoUnit.HOURS)) :
                        controller.get(getId(req));
                req.setAttribute("routine", routine);
                req.getRequestDispatcher("/routineForm.jsp").forward(req, resp);
                break;
            case "delete":
                controller.delete(getId(req));
                resp.sendRedirect("routines");
                break;
            case "getAll":
            default:
                req.setAttribute("routines",
                        controller.getAll());
                req.getRequestDispatcher("/routines.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Routine routine = new Routine(
                req.getParameter("name"),
                req.getParameter("description"),
                LocalDateTime.parse(req.getParameter("startTime")),
                LocalDateTime.parse(req.getParameter("endTime")),
                LocalTime.parse(req.getParameter("timeOfDay"))
        );
        if (StringUtils.isEmpty(req.getParameter("id"))) {
            controller.create(routine);
        } else {
            controller.update(routine, getId(req));
        }
        resp.sendRedirect("routines");
    }

    private int getId(HttpServletRequest req) {
        String stringId = Objects.requireNonNull(req.getParameter("id"));
        return Integer.parseInt(stringId);
    }
}
