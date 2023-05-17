<%--
 * listActivity.jsp
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

<display:table name = "activities" id = "row" requestURI = "${requestURI}" pagesize = "5" class = "displaytag" >

			<spring:message code = "activity.pictures" var = "picturesHeader" />
			<display:column title = "${picturesHeader}">
					<img height="48" width="48" src="${picturesHueader}">
			</display:column>

			<spring:message code = "activity.title" var = "titleHeader" />
			<display:column property = "title" title = "${titleHeader}" />
		
			<spring:message code = "activity.description" var="descriptionHeader" />
			<display:column property="description" title="${descriptionHeader}" />
			
			<spring:message code = "activity.dayWeek" var = "dayWeekHeader" />
			<display:column property = "dayWeek" title = "${dayWeekHeader}" />
			
			<spring:message code = "activity.startTime" var = "startHeader" />
			<display:column property = "startTime" title = "${startHeader}" />
			
			<spring:message code = "activity.endTime" var = "endHeader" />
			<display:column property = "endTime" title = "${endHeader}" />
			
			<spring:message code = "activity.seatsAvailable" var = "seatsAvailableHeader" />
			<display:column property = "seatsAvailable" title = "${seatsAvailableHeader}" />
			
			<display:column>
					<a href="profile/listTrainerByActivity.do?activityId=${row.id}">
						<spring:message code="activity.listOfTrainers" />
					</a>
			</display:column>
			
			<jstl:if test="${row.gym.active == false }">
				<display:column>
						<a href="gym/listGymByActivity.do?activityId=${row.id}">
							<spring:message code="activity.listGym" />
						</a>
				</display:column>
			</jstl:if>	
		
			<security:authorize access="hasRole('MANAGER')">
				<jstl:if test="${manager != null }">
				<display:column>
					<jstl:if test="${row.cancel == false && row.gym.manager eq manager}">
						<a href="activity/cancel.do?activityId=${row.id}">
							<spring:message code="activity.cancel2" />
						</a>
					</jstl:if>	
				</display:column>
				</jstl:if>
			</security:authorize>
		
			<jstl:if test="${var }">
				<security:authorize access="hasRole('CUSTOMER')">
					<display:column>
						<jstl:choose>
							<jstl:when test="${row.gym.customers.contains(principal) && fn:length(row.customers) < row.seatsAvailable && !row.customers.contains(principal)}">
								<a href="activity/joinActivity.do?activityId=${row.id }"><spring:message
										code="activity.joinActivity" /></a>
							</jstl:when>
							<jstl:when test="${row.customers.contains(principal)}">
								<a href="activity/leaveActivity.do?activityId=${row.id }"><spring:message
										code="activity.leaveActivity" /></a>
							</jstl:when>
							<jstl:otherwise>
								--
							</jstl:otherwise>
						</jstl:choose>
					</display:column>
				</security:authorize>		
			</jstl:if>
</display:table>

<jstl:if test="${gym.active == false}">
	<security:authorize access="hasRole('MANAGER')">
		<a href="activity/create.do?gymId=${gym.id}">
			<spring:message code="activity.create" />
		</a>
	</security:authorize>
</jstl:if>

<br>