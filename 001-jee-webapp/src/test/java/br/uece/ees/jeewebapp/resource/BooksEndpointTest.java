package br.uece.ees.jeewebapp.resource;

import java.io.*;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import java.util.ArrayList;
import org.mockito.Matchers;
import org.mockito.InjectMocks;
import static org.junit.Assert.*;
import org.mockito.stubbing.Answer;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import javax.servlet.ServletInputStream;
import java.nio.charset.StandardCharsets;
import br.uece.ees.jeewebapp.domain.model.Book;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mockito.invocation.InvocationOnMock;
import br.uece.ees.jeewebapp.application.BooksApplicationService;

public class BooksEndpointTest
{

    @Mock
    HttpServletRequest requestMock;

    @Mock
    HttpServletResponse responseMock;

    @Mock
    BooksApplicationService booksServiceMock;

    @InjectMocks
    BooksEndpoint booksEndpoint;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        booksEndpoint = new BooksEndpoint(booksServiceMock);

        String json = "{" +
            "   \"title\":\"Zero to One\"," +
            "   \"author\":\"Peter Thiel\"," +
            "   \"summary\":\"\"," +
            "   \"releaseDate\":\"2008-05\"," +
            "   \"identity\":\"\"" +
            "}";

        ServletInputStream mockServletInputStream = mock(ServletInputStream.class);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        when(mockServletInputStream.read(Matchers.<byte[]>any(), anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                byte[] output = (byte[]) args[0];
                int offset = (int) args[1];
                int length = (int) args[2];
                return byteArrayInputStream.read(output, offset, length);
            }
        });
        when(requestMock.getInputStream()).thenReturn(mockServletInputStream);
    }

    @Test
    public void testBooksEndpointDoGetForSingleItem() throws Exception {

        // Given
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getParameter("id")).thenReturn("595de998-611c-4565-8224-9c09c073bb84");
        when(booksServiceMock.requestBook(any(String.class)))
            .thenReturn(new Book(
                "595de998-611c-4565-8224-9c09c073bb84",
                "Zero to One",
                "Peter Thiel",
                "",
                "2014-05"
            ));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doGet(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(200);
        verify(responseMock).setContentType("application/json");

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("2014"));
        assertTrue(stringWriter.toString().contains("Zero to One"));
        assertTrue(stringWriter.toString().contains("Peter Thiel"));
        assertTrue(stringWriter.toString().contains("595de998-611c-4565-8224-9c09c073bb84"));

    }

    @Test
    public void testBooksEndpointDoGetForCollectionOfItems() throws Exception {

        // Given
        when(requestMock.getRequestURI()).thenReturn("/books");
        when(requestMock.getServerName()).thenReturn("localhost");

        List<Book> booksList = new ArrayList<Book>();

        booksList.add(new Book("595de998-611c-4565-8224-9c09c073bb84", "Zero to One", "Peter Thiel", "", "2014-01"));
        booksList.add(new Book("98d12482-32cf-498d-91eb-2e8236235718", "The Lean Startup", "Eric Ries", "", "2011-05"));
        booksList.add(new Book("c3c296b8-65c2-477e-9258-fc292f444981", "Running Lean", "Ash Maurya", "", "2012-05"));
        booksList.add(new Book("a9dd409b-de3a-4536-af10-fce409b0ee29", "Business Model Generation", "Alexander Osterwalder", "", "2010-04"));
        booksList.add(new Book("0a83eb86-1060-44d9-a07b-54a9ad0ba980", "Founders at Work", "Jessica Livingston", "", "2007-05"));

        when(booksServiceMock.allBooks()).thenReturn(booksList);

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doGet(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(200);
        verify(responseMock).setContentType("application/json");

        printWriter.flush();
        assertTrue(stringWriter.toString().contains("Zero to One"));
        assertTrue(stringWriter.toString().contains("The Lean Startup"));
        assertTrue(stringWriter.toString().contains("Running Lean"));
        assertTrue(stringWriter.toString().contains("Business Model Generation"));
        assertTrue(stringWriter.toString().contains("Founders at Work"));

    }

    @Test
    public void testBooksEndpointDoPostWithSuccess() throws Exception {

        // Given
        when(requestMock.getRequestURI()).thenReturn("/books");
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");

        doNothing().when(booksServiceMock).newBook(any(Book.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doPost(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(201);
        verify(responseMock).setContentType("application/json");

    }

    @Test
    public void testBooksEndpointDoPutWithBadRequest() throws Exception {

        // Given
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");

        doNothing().when(booksServiceMock).editBook(any(Book.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doPut(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(400);
        verify(responseMock).setContentType("application/json");

    }

    @Test
    public void testBooksEndpointDoPutWithSuccess() throws Exception {

        // Given
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");
        when(requestMock.getParameter("id")).thenReturn("595de998-611c-4565-8224-9c09c073bb84");

        doNothing().when(booksServiceMock).editBook(any(Book.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doPut(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(204);
        verify(responseMock).setContentType("application/json");

    }

    @Test
    public void testBooksEndpointDoDeleteWithBadRequestError() throws Exception {

        // Given
        when(requestMock.getRequestURI()).thenReturn("/books");
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");

        doNothing().when(booksServiceMock).removeBook(any(String.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doDelete(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(400);
        verify(responseMock).setContentType("application/json");

    }

    @Test
    public void testBooksEndpointDoDeleteWithSuccess() throws Exception {

        // Given
        when(requestMock.getRequestURI()).thenReturn("/books");
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");
        when(requestMock.getParameter("id")).thenReturn("595de998-611c-4565-8224-9c09c073bb84");

        doNothing().when(booksServiceMock).removeBook(any(String.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doDelete(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(204);
        verify(responseMock).setContentType("application/json");

    }

    @Test
    public void testBooksEndpointDoDeleteWithBadRequest() throws Exception {

        // Given
        when(requestMock.getRequestURI()).thenReturn("/books");
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getCharacterEncoding()).thenReturn("UTF-8");
        when(requestMock.getContentType()).thenReturn("application/json");

        doNothing().when(booksServiceMock).removeBook(any(String.class));

        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter   = new PrintWriter(stringWriter);
        when(responseMock.getWriter()).thenReturn(printWriter);

        // When
        booksEndpoint.doDelete(requestMock, responseMock);

        // Then
        verify(responseMock).setStatus(400);
        verify(responseMock).setContentType("application/json");

    }

}
