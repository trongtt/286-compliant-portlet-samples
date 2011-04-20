package t3.samples.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

public class ReserveResourcePortlet extends GenericPortlet
{
   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter writer = response.getWriter();

      ResourceURL resURL = response.createResourceURL();
      resURL.setResourceID("image");
      writer.println("<IMG src=\"" + resURL + "\" >");
   }

   public void serveResource(ResourceRequest resRequest, ResourceResponse resResp) throws PortletException, IOException
   {

      resResp.setContentType("image/png");
      byte[] b = getImage("MyImage.PNG"); //Returns image bytes
      resResp.getPortletOutputStream().write(b);

   }

   private byte[] getImage(String string)
   {
      return null;
   }
}
