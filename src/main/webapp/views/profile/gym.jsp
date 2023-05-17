<%--
 * gyms.jsp
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

<display:table pagesize="5" class="displaytag" keepStatus="true" name="gyms" requestURI="${requestURI}" id="row">
	<!-- Attributes -->
	
	<spring:message code="gym.logo" var="logo" />
	<display:column property="logo" title="${logo}" sortable="false" />

	<spring:message code="gym.name" var="name" />
	<display:column property="name" title="${name}" sortable="false" />

	<spring:message code="gym.address" var="address" />
	<display:column property="address" title="${address}" sortable="false" />
	
	<spring:message code="gym.fee" var="fee" />
	<display:column property="fee" title="${fee}" sortable="false" />
	
	<jstl:choose>
		<jstl:when test="${row.active == true}">
			<display:column>
				<a href="profile/activity.do?activityId=${row.id}">
					<spring:message code="gym.see_activities"/>
				</a>
			</display:column>
		</jstl:when>
	</jstl:choose>
</display:table>