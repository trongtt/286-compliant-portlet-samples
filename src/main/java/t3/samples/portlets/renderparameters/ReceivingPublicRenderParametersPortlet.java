package t3.samples.portlets.renderparameters;

import t3.samples.portlets.RenderingUtils;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ReceivingPublicRenderParametersPortlet extends GenericPortlet {
   
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
   {
      RenderingUtils.renderRenderParemeters(request, response);
   }
}
