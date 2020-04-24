package br.uece.ees.jeewebapp.resource;

import java.io.PrintWriter;
import java.io.IOException;
import com.google.gson.Gson;
import java.util.Collection;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import br.uece.ees.jeewebapp.domain.model.Book;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.uece.ees.jeewebapp.application.BooksApplicationService;
import br.uece.ees.jeewebapp.infrastructure.persistence.HibernateBooksRepository;

@WebServlet(urlPatterns = "/books/*")
public class BooksEndpoint extends HttpServlet
{

    BooksApplicationService booksApplicationService;

    private static final Logger logger = Logger.getLogger(BooksEndpoint.class.getName());

    public BooksEndpoint(BooksApplicationService service)
    {
        this.booksApplicationService = service;
    }

    public BooksEndpoint()
    {
        this.booksApplicationService = new BooksApplicationService(new HibernateBooksRepository());
    }

    protected Book fromRequest(HttpServletRequest request) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonRequest = bufferedReader.readLine();

        Book aBook = new Book();
        if ( jsonRequest != null && !jsonRequest.isEmpty() )
            aBook = new Gson().fromJson(jsonRequest, Book.class);

        String id = request.getParameter("id");
        if (  id != null && !id.isEmpty() )
            aBook.setIdentity(id);

        return aBook;
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        try {
            if ( request.getParameter("id") == null || request.getParameter("id").isEmpty() ) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            Book aBook = fromRequest(request);
            booksApplicationService.editBook(aBook);

        } catch (Exception ignored) {
            logger.log(Level.SEVERE,"Exception Message: ", ignored);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter output = response.getWriter();

        try {
            String bookID = request.getParameter("id");
            if ( bookID == null || bookID.isEmpty() ) {
                Collection<Book> aBooksList = booksApplicationService.allBooks();
                output.print(new Gson().toJson(aBooksList));

                output.flush();
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            }

            Book aBook = booksApplicationService.requestBook(bookID);
            if (aBook == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            output.print(new Gson().toJson(aBook));

            output.flush();
            response.setStatus(HttpServletResponse.SC_OK);

        } catch (Exception ignored) {
            logger.log(Level.SEVERE,"Exception Message: ", ignored);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        try {
            Book aBook = fromRequest(request);
            if (aBook == null) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            booksApplicationService.newBook(aBook);

        } catch (Exception ignored) {
            logger.log(Level.SEVERE,"Exception Message: ", ignored);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("application/json");
        if ( request.getParameter("id") == null || request.getParameter("id").isEmpty() ) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            booksApplicationService.removeBook(request.getParameter("id"));

        } catch (Exception ignored) {
            logger.log(Level.SEVERE,"Exception Message: ", ignored);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

}
