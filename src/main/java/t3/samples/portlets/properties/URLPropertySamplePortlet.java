package t3.samples.portlets.properties;

import t3.samples.portlets.RenderingUtils;

import org.w3c.dom.Element;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class URLPropertySamplePortlet extends GenericPortlet
{
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">This is VIEW mode of sample portlet that is implemented by using Annotation</div>");
      
      PortletURL actionURL = response.createActionURL();
      actionURL.setParameter(ActionRequest.ACTION_NAME, "sayhello");
      actionURL.addProperty("property1", "value1");
      
      w.write("<p> Click <a href=\"" + actionURL.toString()
         + "\">here</a> to execute a Action URL with following parameters :");
      
      PortletURL renderURL = response.createRenderURL();
      renderURL.setPortletMode(PortletMode.EDIT);
      w.write("<p> Click <a href=\"" + renderURL.toString()
         + "\">here</a> to switch to EDIT mode");
      Element element = response.createElement("title");
      element.setTextContent("Hello the world 1");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
      RenderingUtils.renderRenderParemeters(request, response);
   }
}
