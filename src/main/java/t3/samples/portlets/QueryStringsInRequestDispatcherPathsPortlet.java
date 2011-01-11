package t3.samples.portlets;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class QueryStringsInRequestDispatcherPathsPortlet extends GenericPortlet
{
   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      String path ="/portlets/view.jsp?message=Thank you!";

      getPortletContext().getRequestDispatcher(path).include(request,response);
   }
}
