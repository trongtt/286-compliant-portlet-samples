<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects/>
<%
    String eventName = (String)renderRequest.getParameter("eventName");
    String eventData = (String)renderRequest.getParameter("received_name");
    if(eventName == null) {
        eventName = "not received any event";
    }
    if(eventData == null) {
        eventData = "";
    }
%>
<h1>My event receiver sample portlet</h1>
<p>
    Event name: <%=eventName%>
    <br/>
    Last input: <%=eventData%>
</p>