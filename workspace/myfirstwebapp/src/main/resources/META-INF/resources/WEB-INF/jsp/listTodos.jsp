<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
		<title>List Todos Page</title>
	</head>
	<body>
		<div class="container" >
			<h1>Your Todos</h1>
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>username</th>
						<th>Description</th>
						<th>TargetDate</th>
						<th>Is Done ?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todoList}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.username}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
							<td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="add-todo" class="btn btn-success">Add Todo</a>
			
		</div>
		
		<script src="/webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	</body>
</html>