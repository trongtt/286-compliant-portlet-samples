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
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author <a href="mailto:haithanh0809@gmail.com">Nguyen Thanh Hai</a>
 * @version $Id$
 *
 * Common problem in Portlet 1.0:
 *  - Need to pass objects from Action to Render
 *  - Request parameters only handle by strings
 *  - Only option is to park it in the Session
 *  - Not sure when to remove - multiples renders
 * Solution in Portlet 2.0: Action-Scoped Request Attributes
 *  - Container preserves the attributes until no longer needed (new action, for example)
 *  - Action scope ID Render param "javax.portlet.as"
 *  - Can cache multiple scopes so back button will work for multiple actions
 */
public class ActionScopeRequestAttributesPortlet extends GenericPortlet {
  
  @Override
  public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException
  {
    MyObject obj = new MyObject();
    obj.addProperty("foo", "bar");
    request.setAttribute("shared", obj);
  }

  @Override
  protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException
  {
    PortletURL actionURL = response.createActionURL();
    response.setContentType("text/html");
    PrintWriter w = response.getWriter();
    Object obj = request.getAttribute("shared");
    if(obj != null) {
      MyObject myObject = (MyObject)obj;
      w.write("shared object: " + myObject);
    }
    w.write("<p> Action scope ID Render param: " + request.getParameter("javax.portlet.as") + "</p>");
    w.write("<p> Click <a href=\"" + actionURL.toString() + "\">here</a> to pass a object from Action to Render");
  }
  
  public static class MyObject implements Serializable {
    
    private final Map<String, String> properties;
    
    public MyObject() {
      properties = new HashMap<String, String>();
    }
    
    public void addProperty(String name, String value) {
      properties.put(name, value);
    }
    
    public Collection<String> getValues() {
      return properties.values();
    }
    
    public Collection<String> getNames() {
      return properties.keySet();
    }
    
    public Map<String, String> getProperties() {
      return Collections.unmodifiableMap(properties);
    }
    
    @Override
    public String toString() {
      return properties.toString();
    }
  }
}
