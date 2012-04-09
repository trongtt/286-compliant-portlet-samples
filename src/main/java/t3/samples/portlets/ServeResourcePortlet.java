package t3.samples.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

public class ServeResourcePortlet extends AbstractSamplePortlet
{
   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();

      ResourceURL resURL = response.createResourceURL();
      resURL.setResourceID("image");
      writer.write("Click on ResourceURL : <a href=\"" + resURL.toString() + "\">" + resURL.toString() + "</a>");
      renderPortletPreferences(request, response);
   }

   public void serveResource(ResourceRequest resRequest, ResourceResponse resResp) throws PortletException, IOException
   {
      PortletPreferences preferences = resRequest.getPreferences();
      preferences.setValue("mypreference", "tesing");
      preferences.store();

      resResp.getWriter().write("Response from serveResource()");
   }
}
