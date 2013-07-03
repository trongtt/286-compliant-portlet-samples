package t3.samples.portlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class RenderParametersPortlet extends AbstractSamplePortlet {
   
   @Override
   public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
   {
      System.out.println(request.getParameter("actionParam1"));
      System.out.println(request.getParameter("renderParam1"));
      System.out.println(request.getParameter("testing"));
      response.setRenderParameter("renderParam2", "renderParamValue2");
      System.out.println("response.setRenderParameter(\"renderParam2\", \"renderParamValue2\");");
   }
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      PrintWriter writer = response.getWriter();
      
      PortletURL portletURL = response.createActionURL();
      portletURL.setParameter("actionParam1", "actionParamValue1");
      writer.write("Click on an ActionURL : <a href=\"" + portletURL.toString() + "\">" + portletURL.toString() + "</a>");

      portletURL = response.createRenderURL();
      portletURL.setParameter("renderParam1", "renderParamValue1");
      writer.write("<br/>Click on an RenderURL : <a href=\"" + portletURL.toString() + "\">" + portletURL.toString() + "</a>");
      renderRenderParemeters(request, response);
   }
}
