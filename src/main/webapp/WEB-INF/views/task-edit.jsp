<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main class="container">
		<h1>Edit Task</h1>
		
		<form method="post">
		
			<div class="form-group">
			    <label for="name">Task</label>
			    <input class="form-control" id="name" name="name" required minlength="2" autocomplete="off" value="${ task.name }">
			</div>
			
			<div class="form-group">
			    <label for="name">Description</label>
			    <input class="form-control" id="description" name="description" required minlength="2" autocomplete="off" value="${ task.description }">
			</div>
			
			<div class="form-group">
			    <label for="name">Due Date</label>
			    <input class="form-control" type="date" id="due-date" name="dueDate" value="${ task.dueDate }">
			</div>
			
			<div class="form-group">
			    <label for="name">Complete</label>
			    <input type="checkbox" class="form-control" id="complete" name="complete">
			</div>
			
			<button type="submit" class="btn btn-primary">Save</button>
			<a href="/tasks/${ task.id }" class="btn btn-link">Cancel</a>
		</form>
		
	</main>
</body>
</html>