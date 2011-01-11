<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects/>

<div class="portlet-section-body">
  <% System.out.println("\n\n Request :" + request); %>

  <% System.out.println("\n\n RenderRequest :" + renderRequest); %>

    <%= renderRequest.getParameter("message") %>

    <br/>

    <p>${request.message}</p>

</div>
