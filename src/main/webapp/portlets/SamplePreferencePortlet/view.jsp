<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects/>
<%
  PortletURL editURL = renderResponse.createRenderURL();
  editURL.setPortletMode(PortletMode.EDIT);

  PortletPreferences preferences = renderRequest.getPreferences();
  String borderColor = preferences.getValue("border_color", "transparent");
%>
<div style="border: solid 1px <%=borderColor%>">
  <h1>My sample portlet with preference</h1>
  <a href="<%=editURL%>">Click here to edit this portlet</a>
  <p>Hello world!</p>
  <p>
    MY NAME:
  </p>
</div>