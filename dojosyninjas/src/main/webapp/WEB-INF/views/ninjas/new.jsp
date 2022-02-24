<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/dojos">Go back</a></div>
				
				<h3 class="text-center">New Ninja</h3>
				<div class="card">
					<div class="card-body">
						<form:form action="/ninjas" method="POST" id="validate" modelAttribute="ninja">
							<div class="row mx-auto">
							
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="firstName" type="text" class="form-control requires-validation validate-save" name="firstName" id="firstName" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="firstName" class="text-danger backend-validation" />
									  <form:label for="firstName" path="firstName">First Name</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="lastName" type="text" class="form-control requires-validation validate-save" name="lastName" id="lastName" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="lastName" class="text-danger backend-validation" />
									  <form:label for="lastName" path="lastName">Last Name</form:label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="form-floating mb-3">
									  <form:input path="age" type="number" class="form-control requires-validation validate-save validate-minimum" min="18" name="age" id="age" />
									  <div class="invalid-feedback"></div>
									  <form:errors path="age" class="text-danger backend-validation" />
									  <form:label for="age" path="age">Age</form:label>
									</div>
								</div>

								<div class="col-12">
									<div class="form-floating mb-3">
										<form:select path="dojo" id="dojo" class="form-select requires-validation validate-save">
									        <c:forEach var="dojo" items="${dojos_list}">
									            <form:option value="${dojo.id}" path="dojo">
									                <c:out value="${dojo.name}"/>
									            </form:option>
									        </c:forEach>
									    </form:select>
										<div class="invalid-feedback"></div>
										<form:errors path="dojo" class="text-danger backend-validation" />
										<label for="dojo">Select a dojo</label>
									</div>
								</div>
								
								<div class="col-12">
									<div class="d-flex align-items-center justify-content-end">
										<button class="btn btn-primary" type="submit" value="Submit">Create</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- jQuery (No necesario en Bootstrap 5) -->
	<!-- <script src="/webjars/jquery/jquery.min.js"></script> -->
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/validateHelper.js"></script>
	<script src="/js/validateForm.js"></script>
</body>
</html>