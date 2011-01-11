package t3.samples.portlets.annotation;

import t3.samples.portlets.RenderingUtils;

import org.w3c.dom.Element;


import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class AnnotationSamplePortlet extends GenericPortlet
{
   @RenderMode(name = "view")
   public void renderViewMode(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">This is VIEW mode of sample portlet that is implemented by using Annotation</div>");

      PortletURL actionURL = response.createActionURL();
      actionURL.setParameter(ActionRequest.ACTION_NAME, "sayhello");
      w.write("<p> Click <a href=\"" + actionURL.toString()
         + "\">here</a> to execute a Action URL with following parameters :");
      w.write("<br/>- " + ActionRequest.ACTION_NAME + " : sayhello" );

      PortletURL renderURL = response.createRenderURL();
      renderURL.setPortletMode(PortletMode.EDIT);
      w.write("<p> Click <a href=\"" + renderURL.toString()
         + "\">here</a> to switch to EDIT mode");
      Element element = response.createElement("title");
      element.setTextContent("Hello the world 1");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
      RenderingUtils.renderRenderParemeters(request, response);
   }

   @RenderMode(name = "edit")
   public void renderEditMode(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">This is EDIT mode of sample portlet that is implemented by using Annotation</div>");
      
      PortletURL renderURL = response.createRenderURL();
      renderURL.setPortletMode(PortletMode.VIEW);
      w.write("<p> Click <a href=\"" + renderURL.toString() + "\">here</a> to switch to VIEW mode");
   }
   
   @ProcessAction(name = "sayhello")
   public void sayHello(ActionRequest request, ActionResponse response)
   {
      System.out.println("\n========== Start ProcessAction ==========");
      System.out.println("\n           Saying Hello");
      System.out.println("\n========== End ProcessAction ============");
      Element element = response.createElement("title");
      element.setTextContent("Hello the world 3");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);
      response.setRenderParameter("zip-id", "Public render parameter 12fire");
   }
}
