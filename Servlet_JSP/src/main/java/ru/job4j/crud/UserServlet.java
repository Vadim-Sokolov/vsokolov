package ru.job4j.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author vsokolov
 * @version $Id$
 * @since 0.1
 */
public class UserServlet extends HttpServlet {

    private static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
    private final List<String> users = new CopyOnWriteArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append((CharSequence) this.users);
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s2 = req.getParameter("action");
        if(s2.equals("add")){}
        if(s2.equals("update")){}
        if(s2.equals("delete")){}
    }
}
