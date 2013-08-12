package t3.samples.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

public class StateInfoPortlet extends GenericPortlet
{
   @Override
   public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">A portlet demonstrate the Window State feature</div>");

      //
      w.write("<div>Window State : ");
      WindowState[] states = new WindowState[]{WindowState.NORMAL, WindowState.MAXIMIZED, WindowState.MINIMIZED};
      for (WindowState state : states) {
          if (request.getWindowState().equals(state)) {
              w.write(" <strong>" + request.getWindowState() + "</strong>");
          } else if (request.isWindowStateAllowed(state)){
              PortletURL url = response.createRenderURL();
              url.setWindowState(state);
              w.write(" <a href=\"" + url.toString() + "\">" + state + "</a>");
          }
      }
      w.write("</div>");

      //
      w.write("<div>Portlet Mode : ");
      PortletMode[] modes = new PortletMode[]{PortletMode.VIEW, PortletMode.EDIT, PortletMode.HELP};
      for (PortletMode mode : modes) {
          if (request.getPortletMode().equals(mode)) {
              w.write(" <strong>" + request.getPortletMode() + "</strong>");
          } else if (request.isPortletModeAllowed(mode)) {
              PortletURL url = response.createRenderURL();
              url.setPortletMode(mode);
              w.write(" <a href=\"" + url.toString() + "\">" + mode + "</a>");
          }
      }
      w.write("</div>");
   }
}
