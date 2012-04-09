package t3.samples.portlets;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class ReceivingPublicRenderParametersPortlet extends AbstractSamplePortlet {
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      renderRenderParemeters(request, response);
   }
}
