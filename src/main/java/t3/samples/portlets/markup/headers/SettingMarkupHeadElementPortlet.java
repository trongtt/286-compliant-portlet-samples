package t3.samples.portlets.markup.headers;

import org.w3c.dom.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.GenericPortlet;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class SettingMarkupHeadElementPortlet extends GenericPortlet
{
   @Override
   protected void doHeaders(RenderRequest request, RenderResponse response)
   {
      addMarkupHeadElements(response);
   }
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">Add following elements to Html head</div>");

      w.write("<div class=\"portlet-section-header\">"
         + encode("<title>Setting Markup Head Element Portlet in VIEW mode</title>") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">" + encode("<base href=\"base1\" _target=\"test\">") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">" + encode("<base href=\"base2\" _target=\"test\">") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">"
         + encode("<link type=\"text/css\" rel=\"stylesheet\" href=\"mystyle.css\">") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">"
         + encode("<style type=\"text/css\">body {background-color:yellow}</style>") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">"
         + encode("<meta name=\"Description\" content=\"Test add html head elements\" />") + "</div>");
      w.write("<br\\>");

      w.write("<div class=\"portlet-section-header\">"
         + encode("<script type=\"text/javascript\">alert([milliseconds])</script>") + "</div>");
      w.write("<br\\>");

      PortletURL renderURL = response.createRenderURL();
      renderURL.setPortletMode(PortletMode.EDIT);
      w.write("<p> Click <a href=\"" + renderURL.toString() + "\">here</a> to switch to EDIT mode");
   }

   private String encode(String text)
   {
      text = text.replaceAll("<", "&lt;");
      return text.replaceAll(">", "&gt;");
   }

   private void addMarkupHeadElements(RenderResponse response)
   {
      Element element = response.createElement("title");
      element.setTextContent("Setting Markup Head Element Portlet");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, element);

      Element base1 = response.createElement("base");
      base1.setAttribute("href", "base1");
      base1.setAttribute("_target", "test");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, base1);

      Element base2 = response.createElement("base");
      base2.setAttribute("href", "base2");
      base2.setAttribute("_target", "test");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, base2);

      Element link = response.createElement("link");
      link.setAttribute("rel", "stylesheet");
      link.setAttribute("type", "text/css");
      link.setAttribute("href", "mystyle.css");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, link);

      Element style = response.createElement("style");
      style.setAttribute("type", "text/css");
      style.setTextContent("body {background-color:yellow}");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, style);

      Element meta = response.createElement("meta");
      meta.setAttribute("name", "description");
      meta.setAttribute("content", "Test add html head elements");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, meta);

      Element script = response.createElement("script");
      script.setAttribute("type", "text/javascript");
      script.setTextContent("alert('" + String.valueOf(new Date().getTime()) + "')");
      response.addProperty(MimeResponse.MARKUP_HEAD_ELEMENT, script);
   }

   @Override
   protected void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">All extra headers should be removed now</div>");

      PortletURL renderURL = response.createRenderURL();
      renderURL.setPortletMode(PortletMode.VIEW);
      w.write("<p> Click <a href=\"" + renderURL.toString() + "\">here</a> to switch to VIEW mode");
   }
}
