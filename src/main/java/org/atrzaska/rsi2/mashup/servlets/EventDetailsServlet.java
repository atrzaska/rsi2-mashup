package org.atrzaska.rsi2.mashup.servlets;

import com.evdb.javaapi.EVDBAPIException;
import com.evdb.javaapi.EVDBRuntimeException;
import com.evdb.javaapi.data.Event;
import com.evdb.javaapi.operations.EventOperations;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.atrzaska.rsi2.mashup.string.ConvertLineEndingsTransform;
import org.atrzaska.rsi2.mashup.string.ConvertPolishCharactersTransform;
import org.atrzaska.rsi2.mashup.string.ConvertWhitespaceTransform;
import org.atrzaska.rsi2.mashup.string.LowerCaseTransform;
import org.atrzaska.rsi2.mashup.string.RemoveExtraSpacesTransform;
import org.atrzaska.rsi2.mashup.string.RemoveSpecialCharactersTransform;
import org.atrzaska.rsi2.mashup.string.StringProcessor;
import org.atrzaska.rsi2.mashup.youtube.Auth;

@WebServlet(name = "EventDetailsServlet", urlPatterns = {"/eventDetails"})
public class EventDetailsServlet extends HttpServlet {
    private static final long NUMBER_OF_VIDEOS_RETURNED = 2;

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

            YouTube youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest request) throws IOException { }
            }).setApplicationName("rsi2-mashup").build();

            // get event title
            String ytquery = event.getVenueName();

            // process string
            StringProcessor stringProcessor = new StringProcessor(ytquery);
            stringProcessor.addTransform(new ConvertLineEndingsTransform());
            stringProcessor.addTransform(new ConvertPolishCharactersTransform());
            stringProcessor.addTransform(new ConvertWhitespaceTransform());
            stringProcessor.addTransform(new LowerCaseTransform());
            stringProcessor.addTransform(new RemoveExtraSpacesTransform());
            stringProcessor.addTransform(new RemoveSpecialCharactersTransform());

            // get processed string
            ytquery = stringProcessor.getProcessedString();

            // Define the API request for retrieving search results.
            YouTube.Search.List search = youtube.search().list("id,snippet");

            // Set your developer key from the Google Cloud Console for
            // non-authenticated requests. See:
            // https://cloud.google.com/console
            search.setKey("AIzaSyBdEEOnFeozMz2GfHOJx0iOwYS_hImgIsI");

            // set query
            search.setQ(ytquery);

            // Restrict the search results to only include videos. See:
            // https://developers.google.com/youtube/v3/docs/search/list#type
            search.setType("video");

            // To increase efficiency, only retrieve the fields that the
            // application uses.
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            // Call the API and print results.
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            // save object in request
            request.setAttribute("videos", searchResultList);

            // forward request
            RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/eventDetails.jsp");
            rd.forward(request, response);
        } catch (EVDBRuntimeException | EVDBAPIException ex) {
            Logger.getLogger(EventDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
