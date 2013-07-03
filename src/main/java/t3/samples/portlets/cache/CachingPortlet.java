package t3.samples.portlets.cache;

import java.io.IOException;
import java.util.Date;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class CachingPortlet extends GenericPortlet
{

   public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      System.out.println("**---- " + this.getClass().getName() + "'s doView is started");

      if (request.getETag() != null)
      {
         if (request.getETag().startsWith("MY_ETAG"))
         {
            System.out.println("/////// MARKUP IS VALID");
            response.getCacheControl().setExpirationTime(30);
            response.getCacheControl().setUseCachedContent(true);
            return;
         }
      }
      else
      {
         response.getCacheControl().setETag("MY_ETAG" + (new Date()));
         response.getCacheControl().setExpirationTime(30);
         PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/portlets/CachingPortlet/view.jsp");
         dispatcher.include(request, response);
      }
   }
}