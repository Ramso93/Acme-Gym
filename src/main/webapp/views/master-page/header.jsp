<%--
 * header.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Acme Gym Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<%-- FUNCIONES SEGUN EL ROL QUE TENGA ACTOR SON VISIBLES O NO --%>
		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.register" />
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a ><spring:message code="master.page.register.manager" /></a></li>
					<li><a ><spring:message code="master.page.register.customer" /></a></li>
				</ul>
				
			</li>
		</security:authorize>
		<%-- SE PODRÁ VER Anotaciones en Gym, Actividad y Entrenamiento --%>
		<%-- Catalogo de Gyms ->Actividades del gym ->Entrenadores que las imparten --%>
		<%-- Catalogo de Actividades ->Gyms/Entrenadores que la imparten--%>
			<%-- Buscador de Actividades por palabra clave en Tit/Desc --%>
		<%-- Catalogo de Entrenamientos reco --%>
			<%-- Buscador de Entrenamiento por palabra clave en Tit/Desc --%>
		<li>
			<a class="fNiv"> 
				<spring:message code="master.page.catalogue" />
			</a>
			<ul>
				<li class="arrow"></li>
				<li><a href="profile/gym.do"><spring:message code="master.page.catalogue.gym" /></a></li>
				<li><a href="profile/listActivity.do"><spring:message code="master.page.catalogue.activity" /></a></li>
				<li><a href="profile/listWorkout.do"><spring:message code="master.page.catalogue.workout" /></a></li>
			</ul>
		</li>
		
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
				 	<li><a href="administrator/listManagers.do"><spring:message code="master.page.administrator.ban" /></a></li>
					<li><a href="administrator/statistics.do"><spring:message code="master.page.administrator.info" /></a></li>				
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>					
					<li><a href=""><spring:message code="master.page.customer.join_leaveGym" /></a></li>
					<li><a href=""><spring:message code="master.page.customer.jois_leaveActivity" /></a></li>
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="hasRole('MANAGER')">
			<li><a class="fNiv"><spring:message	code="master.page.manager" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href=""><spring:message code="master.page.manager.gym" /></a></li>
					<li><a href=""><spring:message code="master.page.manager.activity" /></a></li>					
					<li><a href=""><spring:message code="master.page.manager.trainer" /></a></li>
					<li><a href=""><spring:message code="master.page.manager.workout" /></a></li>		
				</ul>
			</li>
		</security:authorize>
		<security:authorize access="hasRole('TRAINER')">
		<%-- en bloques C y B no hay funciones excepto edit cv que ya está puesto --%>
		</security:authorize>
		<%-- FUNCIONES COMUNES PARA TODO ACTOR LOGGEADO --%>
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/myprofile.do"><spring:message code="master.page.profile.myprofile" /></a></li>
					<security:authorize access="hasRole('TRAINER')">
						<li><a href=""><spring:message code="master.page.trainer.editcv" /></a></li>
					</security:authorize>			
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>
