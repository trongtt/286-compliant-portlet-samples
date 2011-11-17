package t3.samples.portlets.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class RenderingUtils
{
   
   static public void renderRenderParemeters(RenderRequest request, RenderResponse response) throws IOException {
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">Here are the list of render parameter name/value couples</div>");
      
      Enumeration<String> parameterNames = request.getParameterNames();
      while(parameterNames.hasMoreElements())
      {
         String name = parameterNames.nextElement();
         String[] parameterValues = request.getParameterValues(name);
         for(String value : parameterValues)
         {
            w.write("- " + name + " : " + value + "<br/>");
         }
      }
   }

   static public void renderPortletPreferences(RenderRequest request, RenderResponse response) throws IOException
   {
      PrintWriter w = response.getWriter();
      w.write("<div class=\"portlet-section-header\">Here are the list of Portlet Preferences name/value couples</div>");
      
      PortletPreferences preferences = request.getPreferences();
      Enumeration<String> names = preferences.getNames();
      while(names.hasMoreElements())
      {
         String name = names.nextElement();
         String[] parameterValues = preferences.getValues(name, null);
         for(String value : parameterValues)
         {
            w.write("- " + name + " : " + value + "<br/>");
         }
      }
   }
}
