package t3.samples.portlets;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tuyennt
 * Date: 6/17/13
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyPublicRenderParamReceiverPortlet extends GenericPortlet {
    @RenderMode(name = "view")
    public void renderViewMode(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Public render parameter receiver</h1>");
        writer.println("<p>");
        String param = request.getParameter("test_public_param");
        if(param == null) {
            param = "Not set";
        }
        writer.println("The last param value is: " + param);
        writer.println("</p>");
    }
}
