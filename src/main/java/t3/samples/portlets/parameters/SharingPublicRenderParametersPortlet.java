package t3.samples.portlets.parameters;

import t3.samples.portlets.RenderingUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SharingPublicRenderParametersPortlet extends GenericPortlet {
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">This is VIEW mode of sample portlet that is implemented by using Annotation</div>");

      PortletURL actionURL = response.createActionURL();
//      actionURL.setParameter("testing", "testing value");
      w.write("<p> Click <a href=\"" + actionURL.toString()
         + "\">here</a> to execute a Action URL");
      
      PortletURL renderURL = response.createRenderURL();
      renderURL.setParameter("zip-id", "newValues");
      renderURL.setParameter("param1", "value1");
      renderURL.setParameter("param2", "value2");
      w.write("<p> Click <a href=\"" + renderURL.toString()
         + "\">here</a> to execute a Render URL");
      RenderingUtils.renderRenderParemeters(request, response);
   }
   
   @Override
   public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
   {
//      response.setRenderParameter("zip-id", "Public render parameter 1");
      System.out.println("\n\n=====" + request.getParameter("testing"));
      System.out.println("\n\n=====" + request.getParameter("zip-id"));
   }
}
