package t3.samples.portlets;

import org.w3c.dom.Element;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tuyennt
 * Date: 6/17/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyAnnotationSamplePortlet extends GenericPortlet{
    @RenderMode(name = "view")
    public void renderViewMode(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        request.setAttribute("my_name", "Nguyen The Tuyen");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>This is Other annotation portlet sample</h1>");
        writer.println("This text's printed before dispatcher.include called");

        PortletURL editURL = response.createRenderURL();
        editURL.setPortletMode(PortletMode.EDIT);
        writer.print("<a href=\"");
        editURL.write(writer);
        writer.print("\">");
        writer.print("Click here to switch to edit mode");
        writer.print("</a>");

        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/portlets/MyAnnotationSamplePortlet/view.jsp");
        dispatcher.include(request, response);
    }
    @RenderMode(name = "edit")
    public void renderEditMode(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        PortletURL actionURL = response.createActionURL();
        actionURL.setParameter(ActionRequest.ACTION_NAME, "testAction");
        request.setAttribute("testActionURL", actionURL);

        request.getParameter("test_name");

        PrintWriter writer = response.getWriter();
        writer.println("<h1>This is Other annotation portlet sample</h1>");
        writer.println("This text's printed before dispatcher.include called");
        writer.println("This text will not be displayed");

        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/portlets/MyAnnotationSamplePortlet/edit.jsp");
        dispatcher.forward(request, response);
    }

    @ProcessAction(name = "testAction")
    public void testAction(ActionRequest request, ActionResponse response) {
        String name = request.getParameter("test_name");
        response.setRenderParameter("test_name", name);
        Element element = response.createElement("title");
        element.setTextContent("My Sample annotation sample portlet with edit mode");
        response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);

        response.setRenderParameter("test_public_param", name);

        if(name == null){
            name = "default name";
        }
        response.setEvent("myTestEvent", name);
    }

}
