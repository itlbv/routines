package com.itlbv.routines.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/routines", name = "routinesServlet")
public class RoutinesServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RoutinesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action == null ? "getAll" : action) {
            case "update":
                log.info("update {}", req.getParameter("id"));
                break;
            case "delete":
                log.info("delete");
                break;
            default:
                log.info("get all");
                req.setAttribute("routines",
                        null);
                req.getRequestDispatcher("/routinesServlet.jsp").forward(req, resp);
                break;
        }
    }
}
