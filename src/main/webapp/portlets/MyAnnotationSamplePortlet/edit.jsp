<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects/>

<%@page import="javax.portlet.PortletURL"%>

<%
    PortletURL actionURL = (PortletURL)renderRequest.getAttribute("testActionURL");
    String name = renderRequest.getParameter("test_name");
    if(name == null) name = "";
%>
<h1>My Annotation sample portlet</h1>
<p>
    This is edit mode. Last input name is: <%=name%>
</p>
<form method="POST" action="<%=actionURL%>">
    <input type="text" name="test_name"/>
    <input type="submit"/>
</form>