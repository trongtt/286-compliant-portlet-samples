package t3.samples.portlets;

import javax.portlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tuyennt
 * Date: 6/17/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyEventReceiverPortlet extends GenericPortlet {
    @RenderMode(name = "view")
    public void renderViewMode(RenderRequest request, RenderResponse response) throws PortletException, IOException {

        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/portlets/MyEventReceiverPortlet/view.jsp");
        dispatcher.include(request, response);
    }

    @ProcessEvent(name = "myTestEvent")
    public void processTestEvent(EventRequest request, EventResponse response) {
        System.out.print("Event received");
        Event event = request.getEvent();
        String eventName = event.getName();
        response.setRenderParameter("eventName", eventName);
        String name = (String)event.getValue();
        response.setRenderParameter("received_name", name);
    }
}
