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
 
<form:form modelAttribute="perfil">
	<spring:message code="profile.name"/>:<br>
	<form:input type="text" path="name" value="${perfil.name}" disabled="true"/><br>
	<spring:message code="profile.surname"/>:<br>
	<form:input type="text" path="surname" value="${perfil.surname}"/><br>
	<spring:message code="profile.email"/>:<br>
	<form:input type="text" path="email" value="${perfil.email}"/><br>
	<spring:message code="profile.phoneNumber"/>:<br>
	<form:input type="text" path="phoneNumber" value="${perfil.phoneNumber}"/><br>
	<spring:message code="profile.postalAddres"/>:<br>
	<form:input type="text" path="postalAddres" value="${perfil.postalAddres}"/><br>
	<spring:message code="profile.city"/>:<br>
	<form:input type="text" path="city" value="${perfil.city}"/><br>
	<spring:message code="profile.country"/>:<br>
	<form:input type="text" path="country" value="${perfil.country}"/>
</form:form>
<jstl:if test="${actor.id == perfil.id}">
	<a href="actor/editProfile.do"><spring:message code="profile.edit"/></a>
</jstl:if>
 