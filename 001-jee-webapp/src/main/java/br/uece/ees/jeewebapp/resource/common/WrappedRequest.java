package br.uece.ees.jeewebapp.resource.common;

import java.util.Map;
import java.util.Collections;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WrappedRequest extends HttpServletRequestWrapper
{

    Map<String, String[]> parametersMap;

    public WrappedRequest(final HttpServletRequest request, final Map<String, String[]> additionalParams)
    {
        super(request);
        parametersMap = additionalParams;
    }

    @Override
    public String getParameter(final String name)
    {
        String[] strings = getParameterMap().get(name);
        if ( strings != null )
            return strings[0];

        return super.getParameter(name);
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        parametersMap.putAll(super.getParameterMap());
        return parametersMap;
    }

    @Override
    public Enumeration<String> getParameterNames()
    {
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(final String name)
    {
        return getParameterMap().get(name);
    }

}
