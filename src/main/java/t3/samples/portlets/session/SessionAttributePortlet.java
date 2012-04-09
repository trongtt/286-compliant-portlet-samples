package t3.samples.portlets.session;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SessionAttributePortlet extends GenericPortlet
{

   @Override
   public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
   {
      String portletAttrName = request.getParameter("portlet_attr_name");
      String portletAttrValue = request.getParameter("portlet_attr_value");
      String appAttrName = request.getParameter("app_attr_name");
      String appAttrValue = request.getParameter("app_attr_value");
      request.getPortletSession().setAttribute(portletAttrName, portletAttrValue, PortletSession.PORTLET_SCOPE);
      request.getPortletSession().setAttribute(appAttrName, appAttrValue, PortletSession.APPLICATION_SCOPE);
   }

   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      String path = "/portlets/session/view.jsp";

      getPortletContext().getRequestDispatcher(path).include(request, response);
   }
}