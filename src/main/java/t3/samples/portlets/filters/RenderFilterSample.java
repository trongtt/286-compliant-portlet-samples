package t3.samples.portlets.filters;

import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;

public class RenderFilterSample implements RenderFilter
{
   private String filterName;
   private String portletContextName;
   
   public void init(FilterConfig config) throws PortletException
   {
      filterName = config.getFilterName();
      portletContextName = config.getPortletContext().getPortletContextName();
      System.out.println("DEBUG:  Initializing Portlet Context : " + portletContextName);
   }

   public void doFilter(RenderRequest req, RenderResponse res, FilterChain chain) throws IOException, PortletException
   {
      System.out.println("DEBUG: The " + filterName + " filter Pre-processing a render request");
      chain.doFilter(req, res);
      System.out.println("DEBUG: The " + filterName + " filter Post-processing a render request");
   }

   public void destroy()
   {
      System.out.println("DEBUG: Destroying Portlet Context " + portletContextName);
   }
}