package t3.samples.portlets.coordination.renderparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import t3.samples.portlets.AbstractSamplePortlet;

/**
 * @author <a href="mailto:sontt@exoplatform.com">Son Tran Trong</a>
 *
 * */
public class PublicRenderParamsReceiverPortlet extends AbstractSamplePortlet {

   @RenderMode(name = "view")
   public void renderView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      PrintWriter writer = response.getWriter();
      writer.print("<H1>Coordination Between Portlets - Public Render Parameters</H1>");
      writer.print("<H3>This is public render params receiver</H3>");
      writer.print("<P>Receiving only public render param that named <STRONG>jsr286PublicRenderParam</STRONG> from "
         + "PublicRenderParamPublisherPortlet, not render params were <STRONG>renderParam1</STRONG> and <STRONG>renderParam2</STRONG></P>");
      renderRenderParemeters(request, response);
   }
}
