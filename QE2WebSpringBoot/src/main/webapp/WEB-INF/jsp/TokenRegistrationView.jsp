<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/qe2_stylesheet.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	<title>Token Registration View</title> 
    <script src="/scripts/utility.js"></script> 
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>
    $(document).ready(function(){    	
    	saveFormSubmit();    
    	test();
   	});    	
   	function saveFormSubmit(){   		
		$("#saveForm").submit(function(event){ 
		var keyName = $("#key").val();  
    	var keyValue = $("#value").val(); 
    	if(keyName == "" || keyValue == ""){
    	$("#errormessage1").html("*");
    	$("#errormessage2").html("*");
    	event.preventDefault();
    	}
    	});
    } 
    </script>
 </head>
<body>
	<div id="container">
	<%@ include file="header.jsp" %>
	<%@ include file="menu.jsp" %>			
	<div class="columns">
	    <div class="lilac" >
	       Token Registration<br/><br/>
		    <form  method="GET" action='TokenRegistrationView' name="registrationForm">
			<input type="submit" Value="Token Register" class="quicksearchbutton"/>			   
			<input type="hidden" name="registrationField" value="1">
		   </form> 	             
	       	<c:choose>
				<c:when test="${registrationClientResponse != null}">
				   <br/><br/>	
				  <span class="tokenTitle">New Token ::  <c:out value="${registrationClientResponse}"/></span><br/>
				</c:when>
			</c:choose>	       
	   
	    </div>
	    
	     <div class="grey">Save Token Details<br/><br/>
	       <form  method="GET" action='TokenRegistrationView' name="saveForm" id="saveForm">
			 Token <select id="token" name="token">
			 <c:forEach items="${registrationObjList}" var="registrationObj">
					  <option value="${registrationObj}"><c:out  value="${registrationObj}"/></option>
			</c:forEach>							  
			</select>	
			<br/><br/>
			Key <input type="text" name="key" id="key"/><span id="errormessage1"></span><br/><br/>
			Value <input type="text" name="value" id="value"/><span id="errormessage2"></span><br/><br/>
			<input type="submit" value="Save" name="saveButton" id="saveButton" class="quicksearchbutton"/>
			</form> 
			
			<br/><br/>	<br/>
			<span class="saveTitle"><c:out value="${saveClientResponse}"/>	</span>    
	    </div>
	 
	    <div class="lilac" >Search<br/><br/><br/>
		    <form  method="GET" action='TokenRegistrationView' name="searchForm">
			 Token <select id="searchToken" name="searchToken">
			 <c:forEach items="${registrationObjList}" var="registrationObj">
					  <option value="${registrationObj}"><c:out  value="${registrationObj}"/></option>
			</c:forEach>							  
			</select>	
			<br/><br/>
			Key <input type="text" name="searchKey" id="searchKey"/>
			<br/><br/>
			<input type="submit" value="Search" class="quicksearchbutton"/>
			</form> 
			<br/><br/>	<br/>
			<span class="tokenTitle"><c:out value="${searchClientResponse}"/></span>			
			<c:forEach var="api" items="${searchClientResponseMap}">
			    Key: ${api.key}  - Value: ${api.value} <br/>
			</c:forEach> 
	    </div> 
	</div>
	<div class="clear"></div>
    <br/>
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>