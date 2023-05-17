<%--
 * createManager.jsp
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

<form:form action="profile/registerManager.do" modelAttribute="managerForm">
	
	<fieldset > 
	
	<legend><b> <spring:message code="profile.accountData" /> </b></legend>
	
		<acme:textbox code="profile.username" path="username" mandatory="true"/>
		<br/>
	
		<acme:password code="profile.password" path="password" mandatory="true"/>
		<br/>
	
		<acme:password code="profile.repeatPassword" path="repeatPassword" mandatory="true"/>
	
	</fieldset>
	
	
	<fieldset > 
	
		<legend><b> <spring:message code="profile.personalData" /></b> </legend>
	
	
		<acme:textbox code="profile.name" path="name" mandatory="true"/>
		<br />
			
		<acme:textbox code="profile.surname" path="surname" mandatory="true"/>
		<br />

		<acme:textbox code="profile.phone" path="phone" mandatory="true"/>
		<br />
			
		<acme:textbox code="profile.email" path="email" mandatory="true"/>
		<br />
		
		<acme:textbox code="profile.postalAddress" path="postalAddres"/>
		<br/>
		
		<acme:textbox code="profile.city" path="city"/>
		<br />
		
		<acme:textbox code="profile.country" path="country"/>
		<br/>
	
	</fieldset>

	<acme:submit id="submitButton" name="save" code="profile.submit"/>

</form:form>


<script type="text/javascript">