package t3.samples.portlets.coordination.events;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import t3.samples.portlets.AbstractSamplePortlet;


/**
 * @author <a href="mailto:sontt@exoplatform.com">Son Tran Trong</a>
 *
 * */
public class EventReceiverPortlet extends AbstractSamplePortlet {

   @RenderMode(name = "view")
   public void renderView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      String userName = request.getParameter("userName");
      userName = userName == null || userName.isEmpty() ? "" : userName;

      String eventName = request.getParameter("eventName");
      eventName = eventName == null || eventName.isEmpty() ? "not received any event" : eventName;

      PrintWriter writer = response.getWriter();
      writer.print("<H1>Coordination Between Portlets - Events</H1>");
      writer.print("<H3>This is Event Receiver</H3>");
      writer.print("<P>Event name: <STRONG>" + eventName + "</STRONG></P>");
      writer.print("<P>Last inputed username: <STRONG>" + userName + "</STRONG></P>");
      writer.flush();
      writer.close();
   }

   @ProcessEvent(name = "jsr286Events")
   public void processUserName(EventRequest request, EventResponse response) throws PortletException, IOException {
      Event event = request.getEvent();
      response.setRenderParameter("eventName", event.getName());
      response.setRenderParameter("userName", (String)event.getValue());
   }
}
