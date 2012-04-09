<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<div class="portlet-section-body">
  <form action="<%=renderResponse.createActionURL()%>" method="post">
    <div>
      <h2>Portlet Scope Attribute</h2>
      <label>Portlet Scope Attribute Name: </label><input type="text" name="portlet_attr_name" />
      <label>Portlet Attribute Value: </label><input type="text" name="portlet_attr_value" />
    </div>

    <div>
      <h2>Application Scope Attribute</h2>
      <label>App Scope Attribute Name: </label><input type="text" name="app_attr_name" />
      <label>App Scope Attribute Value: </label><input type="text" name="app_attr_value" />
    </div>
    <input type="submit" />
  </form>
</div>
