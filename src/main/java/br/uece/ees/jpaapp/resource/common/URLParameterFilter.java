package br.uece.ees.jpaapp.resource.common;

import java.util.*;
import javax.servlet.*;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class URLParameterFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Map<String, String[]> parametersMap = buildURLParametersMap(request.getPathInfo());
        filterChain.doFilter(new WrappedRequest(request, parametersMap), servletResponse);
    }

    public Map<String, String[]> buildURLParametersMap(String pathInfo)
    {
        Map<String, String[]> parameters = new HashMap<String, String[]>();
        if ( pathInfo == null || pathInfo.isEmpty() )
            return parameters;

            String paramsStringSet      = pathInfo.substring(pathInfo.indexOf("/") + 1);
            String[] paramsStructureSet = paramsStringSet.split("/");
            for ( int i = 0; i < paramsStructureSet.length; i += 2 )
                parameters.put(paramsStructureSet[i], new String[] { paramsStructureSet[i + 1] });

        return parameters;
    }

}
