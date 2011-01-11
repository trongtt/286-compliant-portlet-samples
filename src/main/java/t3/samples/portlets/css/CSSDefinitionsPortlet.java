package t3.samples.portlets.css;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class CSSDefinitionsPortlet extends GenericPortlet
{
   private static final String NORMAL_VIEW = "/portlets/css/view.jsp";

   private PortletRequestDispatcher normalView;

   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      normalView.include(request, response);
   }

   public void init(PortletConfig config) throws PortletException
   {
      super.init(config);
      normalView = config.getPortletContext().getRequestDispatcher(NORMAL_VIEW);
   }

   public void destroy()
   {
      normalView = null;
      super.destroy();
   }

}
