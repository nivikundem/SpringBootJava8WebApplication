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
	<%-- <style type="text/css"><%@include file="css/qe2_stylesheet.css" %></style> --%>
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/qe2_stylesheet.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	
	<title>About View</title> 	
</head>
<body>
	<div id="container">
    <!-- header -->
   	<%@ include file="header.jsp" %>
    <!-- menu -->
    <%@ include file="menu.jsp" %>	
	<!--content-->
	   <div id="textPara">		   
		    Using <br/><br/>
		    Java 8/J2E<br/>	
		    Spring Boot<br/>	    
		    Spring MVC<br/>		    
		    Spring JPA/Hibernate <br/>
		    Spring JMS/ActiveMQ<br/>	
		    Maven<br/>
		    MySql<br/>
		    Tomcat(Built In)<br/>		    
		    JSP/JSTL<br/>	
		    HTML/CSS <br/>				    
		    Javascript/jQuery <br/> 
		    SOAP Client/Server <br/>
		    REST Client/Server <br/>	
		    
		 </div>		
	<!-- footer -->
	<%@ include file="footer.jsp" %>
</div>
</body>
</html>