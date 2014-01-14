package org.atrzaska.rsi2.mashup.servlets;

import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.operations.EventOperations;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventDetailsServlet", urlPatterns = {"/eventDetails"})
public class EventDetailsServlet extends HttpServlet {
    private static final long NUMBER_OF_VIDEOS_RETURNED = 25;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            // set api key
            com.evdb.javaapi.APIConfiguration.setApiKey("wfRjDLRTfp3tsS7X");
            com.evdb.javaapi.APIConfiguration.setEvdbUser("karthaxx");
            com.evdb.javaapi.APIConfiguration.setEvdbPassword("wacha5656");

            // read query param
            String seid = request.getParameter("seid");

            // get event
            EventOperations eventOperations = new EventOperations();
            Event event = eventOperations.get(seid);

            request.setAttribute("event", event);

            // forward request
            RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/eventDetails.jsp");
            rd.forward(request, response);
        } catch (EVDBRuntimeException | EVDBAPIException ex) {
            Logger.getLogger(EventDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
