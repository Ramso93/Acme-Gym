<%--
 * listTrainer.jsp
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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<display:table name = "trainers" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >
	
	<spring:message code="profile.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="false" />

	<spring:message code="profile.surname" var="surnameHeader" />
	<display:column property="surname" title="${surnameHeader}" sortable="false" />

	<spring:message code="profile.email" var="emailHeader" />
	<display:column property="email" title="${emailHeader}" sortable="false" />
	
	<spring:message code="profile.phoneNumber" var="phoneNumberHeader" />
	<display:column property="phoneNumber" title="${phoneNumberHeader}" sortable="false" />
	
	<spring:message code="profile.postalAddres" var="postalAddresHeader" />
	<display:column property="postalAddres" title="${postalAddresHeader}" sortable="false" />
	
	<spring:message code="profile.city" var="cityHeader" />
	<display:column property="city" title="${cityHeader}" sortable="false" />
	
	<spring:message code="profile.country" var="countryHeader" />
	<display:column property="country" title="${countryHeader}" sortable="false" />
	
	<security:authorize access="isAnonymous()">
	<display:column>
			<a href="profile/verCV.do?trainerId=${row.id}">
				<spring:message code="profile.verCV" />
			</a>
	</display:column>
	</security:authorize>
</display:table>