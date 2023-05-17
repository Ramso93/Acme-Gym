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

<form:form modelAttribute="workout">
	<fieldset>
	<spring:message code="workout.title"/>:<br>
	<form:input type="text" path="title" value="${workout.title}" disabled="true"/><br>
	<spring:message code="workout.description"/>:<br>
	<form:input type="text" path="description" value="${workout.description}" disabled="true"/><br>
				
	</fieldset>
</form:form>
<jstl:if test="${actor.id == perfil.id}">
	<a href="profile/myprofile/editWorkout.do?workoutId=${workout.id}"><spring:message code="workout.edit"/></a>
</jstl:if>