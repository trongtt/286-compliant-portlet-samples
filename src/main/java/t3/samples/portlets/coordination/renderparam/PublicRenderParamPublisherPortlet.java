package t3.samples.portlets.coordination.renderparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import t3.samples.portlets.AbstractSamplePortlet;

/**
 * @author <a href="mailto:sontt@exoplatform.com">Son Tran Trong</a>
 *
 * */
public class PublicRenderParamPublisherPortlet extends AbstractSamplePortlet {

   @RenderMode(name = "view")
   public void renderView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      PrintWriter writer = response.getWriter();
      writer.print("<H1>Coordination Between Portlets - Public Render Parameters</H1>");
      writer.print("<H3>This is public render params publisher</H3>");
      writer.print("<P><STRONG>Notice:</STRONG> don't be confused between PortletURL.setParameter and "
         + "ActionResponse.setRenderParameter and ActionResponse.setRenderParameter with PublicRenderParam configuration.<P>");
      writer.print("<P>- PortletURL.setParameter & ActionResponse.setRenderParameter: the parameter are available only in the render phase "
         + "of the SAME portlet</P>");
      writer.print("<P>- ActionResponse.setRenderParameter with PublicRenderParam configuration (portlet 2.0): the parameters set in the "
         + "processAction() method of in one portlet are available in render parameters of the other portlets</P>");
      writer.print("<P>Examining the following example with 3 parameters.<BR/>" +
      		"1. Render param that named <STRONG>jsr286PublicRenderParam</STRONG> is set by ActionResponse.setRenderParameter() " +
      		"in action phase with PublicRenderParam configuration in portlet.xml.<BR/> " +
      		"2. Render param that named <STRONG>renderParam1</STRONG> is set by PortletURL.setParameter() in render phase.<BR/>" +
      		"3. Render param that named <STRONG>renderParam2</STRONG> is set by ActionResponse.setRenderParameter() " +
            "in action phase.</P>");

      PortletURL actionURL = response.createActionURL();
      actionURL.setParameter(ActionRequest.ACTION_NAME, "publishRenderParam");
      writer.print("<P> Click <A href=\"" + actionURL.toString() + "\">here</A> to execute a Action URL</P>");

      PortletURL renderURL = response.createRenderURL();
      renderURL.setParameter("renderParam1", "render param is set in render phase of PublicRenderParamPublisherPortlet");
      writer.print("<P> Click <A href=\"" + renderURL.toString() + "\">here</A> to execute a Render URL</P>");
      renderRenderParemeters(request, response);

      writer.flush();
      writer.close();
   }

   @ProcessAction(name = "publishRenderParam")
   public void publishRenderParam(ActionRequest request, ActionResponse response) throws PortletException, IOException {
      response.setRenderParameter("jsr286PublicRenderParam",
         "render param is set in processAction() of PublicRenderParamPublisherPortlet with PublicRenderParam configuration in portlet.xml.");
      response.setRenderParameter("renderParam2", "render param is set in action phase of PublicRenderParamPublisherPortlet");
   }
}
