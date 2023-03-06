<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head> <title> ChatLog Page </title> </head>
	<body> 
	<h3>Welcome to Chat Log</h3>
		
		<table class="table">
		<thead>
			<tr>
				<th>Chat Logs</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${msgList}" var="msgList">
				<tr>
					<td>${msgList}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</body>
</html>