package org.atrzaska.rsi2.mashup.servlets;

import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.data.SearchResult;
import com.evdb.javaapi.data.request.EventSearchRequest;
import com.evdb.javaapi.operations.EventOperations;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "PopularEventsServlet", urlPatterns = {"/popularEvents"})
public class PopularEventsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            // set api key
            com.evdb.javaapi.APIConfiguration.setApiKey("wfRjDLRTfp3tsS7X");
            com.evdb.javaapi.APIConfiguration.setEvdbUser("karthaxx");
            com.evdb.javaapi.APIConfiguration.setEvdbPassword("wacha5656");

            // set event search keywords
            EventOperations eventOperations = new EventOperations();
            EventSearchRequest eventSearchRequest = new EventSearchRequest();
            eventSearchRequest.setSortOrder(EventSearchRequest.SortOrder.RELEVANCE);

            // search
            SearchResult searchResult = eventOperations.search(eventSearchRequest);
            List<Event> events = searchResult.getEvents();
            request.setAttribute("events", events);

            // forward request
            RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/searchResults.jsp");
            rd.forward(request, response);
        } catch (EVDBRuntimeException | EVDBAPIException ex) {
            Logger.getLogger(KeywordSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
