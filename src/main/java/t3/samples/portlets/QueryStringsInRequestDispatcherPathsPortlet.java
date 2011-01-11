package t3.samples.portlets;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * <pre>
 * <h1>PLT.19.1.1 Query Strings in Request Dispatcher Paths</h1>
 * The getRequestDispatcher method of the PortletContext that creates
 * PortletRequestDispatcher objects using path information allows the optional
 * attachment of query string information to the path. For example, a Developer may obtain
 * a PortletRequestDispatcher by using the following code:
 * 
 * String path = "/raisons.jsp?orderno=5";
 * PortletRequestDispatcher rd = context.getRequestDispatcher(path);
 * rd.include(renderRequest, renderResponse);
 * 
 * Parameters specified in the query string used to create the PortletRequestDispatcher
 * must be aggregated with the portlet render parameters and take precedence over other
 * portlet render parameters of the same name passed to the included servlet or JSP. The
 * parameters associated with a PortletRequestDispatcher are scoped to apply only for
 * the duration of the include call.
 * </pre>
 * 
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class QueryStringsInRequestDispatcherPathsPortlet extends GenericPortlet
{
   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      String path ="/portlets/QueryStringsInRequestDispatcherPathsPortlet/view.jsp?message=Thank you!";

      getPortletContext().getRequestDispatcher(path).include(request,response);
   }
}
