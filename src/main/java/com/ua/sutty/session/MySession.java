package com.ua.sutty.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/temp")
public class MySession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            String attribute = attributeNames.nextElement();
            System.out.println(attribute + session.getAttribute(attribute));
        }
        session.setAttribute("one", "two");
//        check
        session.isNew();
//        clean sesion
        session.invalidate();
        System.out.println(session.getMaxInactiveInterval());
    }
}
