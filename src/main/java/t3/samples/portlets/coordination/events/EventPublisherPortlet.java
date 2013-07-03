package t3.samples.portlets.coordination.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import t3.samples.portlets.AbstractSamplePortlet;

/**
 * @author <a href="mailto:sontt@exoplatform.com">Son Tran Trong</a>
 *
 * */
public class EventPublisherPortlet extends AbstractSamplePortlet {

   @RenderMode(name = "view")
   public void renderView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      PortletURL actionURL = response.createActionURL();
      actionURL.setParameter(ActionRequest.ACTION_NAME, "processUserName");

      PrintWriter writer = response.getWriter();
      writer.print("<H1>Coordination Between Portlets - Events</H1>");
      writer.print("<H3>This is event publisher</H3>");
      writer.print("<FORM method=\"POST\" action=\"" + actionURL.toString() + "\">");
      writer.print("   <INPUT type=\"text\" name=\"userName\"/>");
      writer.print("   <INPUT type=\"submit\"/>");
      writer.print("</FORM>");
      writer.flush();
      writer.close();
   }

   @ProcessAction(name = "processUserName")
   public void processUserName(ActionRequest request, ActionResponse response) throws PortletException, IOException {
      String userName = request.getParameter("userName");
      if (userName == null || userName.isEmpty()) {
         userName = "You didn't entered userName yet!";
      }

      response.setEvent("jsr286Events", userName);
   }
}