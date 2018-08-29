<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a task</title>
</head>
<body>
<main class="container">
		<h1>Add a new task</h1>
		
		
		<form action="/submit-task" method="post">
			<div class="form-group">
			    <label for="name">Task Name</label>
			    <!-- pre-populate the input value from the existing (if any) -->
			    <input class="form-control" id="name" name="name" value="${task.name}" required minlength="2">
			</div>
			<div class="form-group">
			    <label for="description">Description</label>
			    <input class="form-control" id="description" name="description" value="${task.description}" required>
			</div>
			<div class="form-group">
			    <label for="quantity">Due Date</label>
			    <input class="form-control" id="dueDate" name="dueDate" value="${task.dueDate}" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/submit-add" class="btn btn-link">Cancel</a>
		</form>
	</main>
</body>
</html>