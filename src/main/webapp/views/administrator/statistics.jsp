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

<br>

<p><spring:message code="administrator.statics2"></spring:message></p>
<display:table pagesize="5" class="displaytag" name="statistics2" requestURI="${requestURI}" id="statistics2">
	<spring:message code="statistics.min" var="minHeader2" />
	<display:column title="${minHeader2}">
		<h3> <jstl:out value="${statistics2[0]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.max" var="maxHeader2" />
	<display:column title="${maxHeader2}">
		<h3> <jstl:out value="${statistics2[1]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.prom" var="promHeader2" />
	<display:column title="${promHeader2}">
		<h3> <jstl:out value="${statistics2[2]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.desv" var="desvHeader2" />
	<display:column title="${desvHeader2}">
		<h3> <jstl:out value="${statistics2[3]}" /> </h3> 
	</display:column>
</display:table>

<br>

<p><spring:message code="administrator.statics3"></spring:message></p>
<display:table pagesize="5" class="displaytag" name="statistics3" requestURI="${requestURI}" id="statistics3">
	<spring:message code="statistics.min" var="minHeader3" />
	<display:column title="${minHeader3}">
		<h3> <jstl:out value="${statistics3[0]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.max" var="maxHeader3" />
	<display:column title="${maxHeader3}">
		<h3> <jstl:out value="${statistics3[1]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.prom" var="promHeader" />
	<display:column title="${promHeader3}">
		<h3> <jstl:out value="${statistics3[2]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.desv" var="desvHeader3" />
	<display:column title="${desvHeader3}">
		<h3> <jstl:out value="${statistics3[3]}" /> </h3> 
	</display:column>
</display:table>

<br>

<p><spring:message code="administrator.statics4"></spring:message></p>
<jstl:forEach items="${statistics4}" var="item">
	<h3><jstl:out value="${item.name}"></jstl:out></h3>
</jstl:forEach>

<br>

<p><spring:message code="administrator.statics5"></spring:message></p>
<jstl:forEach items="${statistics5}" var="item2">
	<h3><jstl:out value="${item2.userAccount.username}"></jstl:out></h3>
</jstl:forEach>

<br>

<p><spring:message code="administrator.statics6"></spring:message></p>
<display:table pagesize="5" class="displaytag" name="statistics6" requestURI="${requestURI}" id="statistics6">
	<spring:message code="statistics.min" var="minHeader6" />
	<display:column title="${minHeader6}">
		<h3> <jstl:out value="${statistics6[0]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.prom" var="promHeader6" />
	<display:column title="${promHeader6}">
		<h3> <jstl:out value="${statistics6[1]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.max" var="maxHeader6" />
	<display:column title="${maxHeader6}">
		<h3> <jstl:out value="${statistics6[2]}" /> </h3> 
	</display:column>
</display:table>

<br>

<p><spring:message code="administrator.statics7"></spring:message></p>
<display:table pagesize="5" class="displaytag" name="statistics7" requestURI="${requestURI}" id="statistics7">
	<spring:message code="statistics.min" var="minHeader7" />
	<display:column title="${minHeader7}">
		<h3> <jstl:out value="${statistics7[0]}" /> </h3> 
	</display:column>

	<spring:message code="statistics.prom" var="promHeader7" />
	<display:column title="${promHeader7}">
		<h3> <jstl:out value="${statistics7[1]}" /> </h3> 
	</display:column>
	
	<spring:message code="statistics.max" var="maxHeader7" />
	<display:column title="${maxHeader7}">
		<h3> <jstl:out value="${statistics7[2]}" /> </h3> 
	</display:column>
</display:table>

<br>

<p><spring:message code="administrator.statics8"></spring:message></p>
	<jstl:forEach items="${statistics8}" var="item3">
		<h3><jstl:out value="${item3.title}"></jstl:out></h3>
	</jstl:forEach>

<br>