package br.uece.ees.jeewebapp.resource.common;

import java.util.Map;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLParameterFilterTest {

    @InjectMocks
    URLParameterFilter urlParameterFilterMock;

    @Mock
    HttpServletRequest requestMock;

    @Mock
    HttpServletResponse responseMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuildURLParametersMap() throws Exception {

        // Given
        when(requestMock.getServerName()).thenReturn("localhost");
        when(requestMock.getParameter("param-4")).thenReturn("value-4");
        when(requestMock.getPathInfo()).thenReturn("/param-1/value-1/param-2/value-2/param-3/value-3");

        // When
        Map<String, String[]> parametersMap = urlParameterFilterMock.buildURLParametersMap(requestMock.getPathInfo());
        WrappedRequest wrappedRequest = new WrappedRequest(requestMock, parametersMap);

        // Then
        assertEquals(wrappedRequest.getParameter("param-1"), "value-1");
        assertEquals(wrappedRequest.getParameter("param-2"), "value-2");
        assertEquals(wrappedRequest.getParameter("param-3"), "value-3");
        assertEquals(wrappedRequest.getParameter("param-4"), "value-4");

    }

}
