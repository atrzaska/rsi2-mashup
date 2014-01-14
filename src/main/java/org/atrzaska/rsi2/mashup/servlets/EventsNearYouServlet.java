package org.atrzaska.rsi2.mashup.servlets;

import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.operations.EventOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventsNearYouServlet", urlPatterns = {"/eventsNearYou"})
public class EventsNearYouServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        response.setContentType("text/html;charset=UTF-8");

        com.evdb.javaapi.APIConfiguration.setApiKey("wfRjDLRTfp3tsS7X");
        com.evdb.javaapi.APIConfiguration.setEvdbUser("karthaxx");
        com.evdb.javaapi.APIConfiguration.setEvdbPassword("wacha5656");

        EventOperations eventOperations = new EventOperations();
        Event event = null;

        try {
            event = eventOperations.get(String.valueOf(id));
        } catch (EVDBRuntimeException | EVDBAPIException ex) {
            Logger.getLogger(EventsNearYouServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("Event: " + event.getTitle());
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    }
}
