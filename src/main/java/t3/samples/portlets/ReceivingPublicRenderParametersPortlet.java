package t3.samples.portlets;

import t3.samples.portlets.util.RenderingUtils;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="trongtt@gmail.com">Trong Tran</a>
 * @version $Revision$
 */
public class ReceivingPublicRenderParametersPortlet extends GenericPortlet {
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      RenderingUtils.renderRenderParemeters(request, response);
   }
}
