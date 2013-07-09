/*
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package t3.samples.portlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Cookie;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * @version $Id$
 *
 */
public class CookiesPortlet extends GenericPortlet {

  @Override
  public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
  {
    response.addProperty(new Cookie("timestamp", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(new Date())));
  }
  
  @Override
  protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
  {
    PrintWriter writer = response.getWriter();
    writer.print("<p>List of Cookies: </p>");
    writer.print("<ul>");
    for (Cookie cookie : request.getCookies()) {
      writer.print("<li>" + cookie.getName() +  " = " + cookie.getValue() + "</li>");
    }
    PortletURL actionURL = response.createActionURL();
    writer.print("</ul>");
    writer.print("<p>Click <a href='" + actionURL.toString() +"'>here</a> to add a cookie");
  }
}
