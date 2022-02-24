<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojos</title>
	<!-- Bootstrap -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	
	<div class="container py-5">
		<div class="d-flex justify-content-center">
			<div class="container">
				<div class="pt-2 pb-4"><a href="/dojos">Go back</a></div>
				
				<!--<div class="d-flex justify-content-between align-items-center pt-2 pb-4">
					<a href="/dojos/${dojo.id}/edit" class="btn btn-info text-white">Edit</a>
					<form action="/dojos/${dojo.id}" method="post">
			      		<input type="hidden" name="_method" value="DELETE">
			      		<button type="submit" class="btn btn-danger">Delete</button>
			      	</form>
				</div> -->
				
				<div class="card">
					<div class="card-header">
						<h3>Location: <c:out value="${dojo.name}"></c:out></h3>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-hover">
							  <thead>
							    <tr>
							      <th scope="col">Id</th>
							      <th scope="col">Student</th>
							      <th scope="col">Age</th>
							      <!-- <th scope="col">Actions</th> -->
							    </tr>
							  </thead>
							  <tbody>
								  <c:forEach var="ninja" items="${dojo.ninjas}">
									<tr>
								      <th scope="row">${ninja.id}</th>
								      <td>${ninja.firstName} ${ninja.lastName}</td>
								      <td>${ninja.age}</td>
								    </tr>
								</c:forEach>
							  </tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!--Bootstrap -->
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>