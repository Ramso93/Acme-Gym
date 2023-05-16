<%--
 * edit.jsp
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

<form:form action="profile/myprofile/edit.do" modelAttribute="myprofile">
	
	<fieldset > 
		<legend><b> <spring:message code="profile.personalData" /></b> </legend>
		<spring:message code="profile.name"/>:<br>
		<form:input type="text" path="name" value="${perfil.name}"/><br>
			
		<spring:message code="profile.surname"/>:<br>
		<form:input type="text" path="surname" value="${perfil.surname}"/><br>
		
		<spring:message code="profile.email"/>:<br>
		<form:input type="text" path="email" value="${perfil.email}"/><br>
		
		<spring:message code="profile.phoneNumber"/>:<br>
		<form:input type="text" path="phoneNumber" value="${perfil.phoneNumber}" /><br>
		
		<spring:message code="profile.postalAddres"/>:<br>
		<form:input type="text" path="postalAddres" value="${perfil.postalAddres}" /><br>
		
		<spring:message code="profile.city"/>:<br>
		<form:input type="text" path="city" value="${perfil.city}" /><br>
		
		<spring:message code="profile.country"/>:<br>
		<form:input type="text" path="country" value="${perfil.country}" />
	
	</fieldset>
	<input type="submit" name="save" value="<spring:message code='profile.submit'/>" />

	<input type="button" value="<spring:message code='profile.cancel'/>" onclick="window.location.href='profile/myprofile.do'"/>

</form:form>