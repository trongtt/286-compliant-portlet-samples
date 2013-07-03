package t3.samples.portlets;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: tuyennt
 * Date: 6/14/13
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimplePortlet extends AbstractSamplePortlet {
   @Override
   protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
      PrintWriter out = response.getWriter();
      out.println("Hello world!");
   }
}
