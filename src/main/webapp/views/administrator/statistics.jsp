<%--
 * statistics.jsp
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

<p><spring:message code="administrator.statics"></spring:message></p>
<display:table pagesize="5" class="displaytag" name="statistics1" requestURI="${requestURI}" id="statistics1">
	<spring:message code="statistics.min" var="minHeader" />
	<display:column title="${minHeader}">
		<h3> <jstl:out value="${statistics1[0]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.max" var="maxHeader" />
	<display:column title="${maxHeader}">
		<h3> <jstl:out value="${statistics1[1]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.prom" var="promHeader" />
	<display:column title="${promHeader}">
		<h3> <jstl:out value="${statistics1[2]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.desv" var="desvHeader" />
	<display:column title="${desvHeader}">
		<h3> <jstl:out value="${statistics1[3]}" /> </h3> 
	</display:column>
</display:table>