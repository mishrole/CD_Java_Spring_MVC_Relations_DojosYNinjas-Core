<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<!-- <div class="pt-2 pb-4"><a href="/">Go back</a></div> -->
				
				<div class="d-flex justify-content-between align-items-center pb-4">
					<h3>Dojos</h3>
					<div>
						<a href="/ninjas" class="btn btn-secondary">New Ninja</a>
					</div>
				</div>
				
				<div class="card mb-4">
					<div class="card-body">
						<h3 class="pt-2 pb-3">New Dojo</h3>
						<form:form action="/dojos" method="POST" id="validate" modelAttribute="dojo">
							<div class="row mx-auto">
								<div class="col-12">
									<div class="form-floating mb-3">
										<form:input path="name" type="text" class="form-control requires-validation validate-save" name="name" id="name" />
										<div class="invalid-feedback"></div>
										<form:errors path="name" class="text-danger backend-validation" />
										<form:label for="name" path="name">Location</form:label>
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
				
				<div class="table-responsive">
					<table class="table table-hover">
					  <thead>
					    <tr>
					      <th scope="col">Id</th>
					      <th scope="col">Location</th>
					      <th scope="col">Actions</th>
					    </tr>
					  </thead>
					  <tbody>
						  <c:forEach var="dojo" items="${dojos}">
							<tr>
						      <th scope="row">${dojo.id}</th>
						      <td>${dojo.name}</td>
						      <td><a href="/dojos/${dojo.id}">See students</a></td>
						    </tr>
						</c:forEach>
					  </tbody>
					</table>
				</div>
				
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<!-- Javascript Local -->
	<script src="/js/validateHelper.js"></script>
	<script src="/js/validateForm.js"></script>
</body>
</html>