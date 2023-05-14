<%--
 * listManagers.jsp
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

<display:table pagesize="7" class="displaytag" keepStatus="true"
	name="managers" requestURI="${requestURI}" id="row">
	
	<!-- Attributes -->
	
	<spring:message code="actor.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="false" />

	<spring:message code="actor.surname" var="surnameHeader" />
	<display:column property="surname" title="${surnameHeader}" sortable="false" />

	<spring:message code="actor.email" var="emailHeader" />
	<display:column property="email" title="${emailHeader}" sortable="false" />
	
	<spring:message code="actor.phoneNumber" var="phoneNumberHeader" />
	<display:column property="phoneNumber" title="${phoneNumberHeader}" sortable="false" />
	
	<spring:message code="actor.postalAddress" var="postalAddresHeader" />
	<display:column property="postalAddres" title="${postalAddresHeader}" sortable="false" />
	
	<spring:message code="actor.city" var="cityHeader" />
	<display:column property="city" title="${cityHeader}" sortable="false" />
	
	<spring:message code="actor.country" var="countryHeader" />
	<display:column property="country" title="${countryHeader}" sortable="false" />
	
	<spring:message code="actor.baneado" var="baneadoHeader" />
	<display:column property="baneado" title="${baneadoHeader}" sortable="false" />
	
</display:table>