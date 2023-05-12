<%--
 * myprofile.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<p><spring:message code="profile.myprofile" /></p>
 
<form:form modelAttribute="myprofile">
	
	<form:input type="hidden" path="name" value="${myprofile.name}"/>
	<form:input type="hidden" path="surname" value="${myprofile.surname}"/>
	<form:input type="hidden" path="email" value="${myprofile.email}"/>
	<form:input type="hidden" path="phoneNumber" value="${myprofile.phoneNumber}"/>
	<form:input type="hidden" path="postalAddress" value="${myprofile.postalAddress}"/>
	<form:input type="hidden" path="city" value="${myprofile.city}"/>
	<form:input type="hidden" path="country" value="${myprofile.country}"/>
</form:form>
 