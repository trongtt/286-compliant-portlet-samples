package t3.samples.portlets.windowstate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class WindowStatePortlet extends GenericPortlet
{
   @Override
   public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
   {
      response.setWindowState(WindowState.MAXIMIZED);
   }

   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">A portlet demonstrate the Window State feature</div>");

      PortletURL renderURL = response.createRenderURL();
      renderURL.setWindowState(WindowState.MINIMIZED);
      w.write("<p> Click <a href=\"" + renderURL.toString() + "\">here</a> to change the portlet window state to MINIMIZED");
      
      PortletURL actionURL = response.createActionURL();
      w.write("<p> Click <a href=\"" + actionURL.toString() + "\">here</a> to change the portlet window state to MAXIMIZED");
   }
}
