<%-- 
    Document   : user
    Created on : Aug 6, 2018, 10:25:30 AM
    Author     : rajendarreddy jagapathi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"
	integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
	crossorigin="anonymous"></script>
<script type="text/javascript">
    //Rename old form Elements to _old
	$(document).ready(function() {
		$("input[type='hidden']").each(function() {
			var elementName = $(this).attr('name');
			if(elementName.match('_chk')){
				$(this).attr('name',elementName+"_old");
			}
		});
	});
</script>
</head>
<body>
	<form name="displ" action="userAction.do" method="post">
		<display:table id="data" name="sessionScope.UserForm.actorList"
			requestURI="/userAction.do?pagetagtype=tag" pagesize="5"
			decorator="com.rajendarreddyj.displaytag.RadioButtonDecorator" form="displ"
			excludedParams="_chk">
			<display:column property="id" title="Id" sortable="true" />
			<display:column property="tvShow" title="TV Show" sortable="true" />
			<display:column property="userName" title="User Name" sortable="true" />
			<display:column property="emailId" title="Email Id" sortable="true" />
			<display:column property="radioButton" />
		</display:table>
	</form>
</body>
</html>
