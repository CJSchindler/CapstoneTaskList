<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Nope, nothing here either.

<div class="container">
		<h1>Menu</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Task</th><th>Description</th><th>Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="task" tasks="${task}">
				<tr>
					<td><a href="/tasks/">${task.name}</a></td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td>
						<a href="/tasks/${ task.id }/edit-task" class="btn btn-light btn-sm">Edit</a>
						<a href="/tasks/${ task.id }/delete" class="btn btn-light btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/add-item" class="btn btn-medium btn-sm">Add task</a>
	</div>
</body>
</html>