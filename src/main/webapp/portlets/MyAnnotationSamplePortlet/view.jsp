<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<portlet:defineObjects/>

<h1>My Annotation sample portlet</h1>
<p>Hello world!</p>
<p>
    MY NAME: <%=renderRequest.getAttribute("my_name")%>
</p>