<html>
	<head> <title> Login Page </title> </head>
	<body> Welcome ${currentUserName}
		<a href="Chat-Logs-Default?userName=${currentUserName}">See</a> last 10 chat logs
		<br>
		<br>
		<a href="Chat-Logs-Limited">See</a> limited logs
		<br>
		<br>
		<a href="Chat-Logs-Delete">Click</a> to delete all logs
		<br>
		<br>
		<a href="Chat-Logs-Delete-Single-Log">Click</a> to delete log by id
		<br>
		<br>
		<a href="Add-New-Log">Add</a> new logs
	</body>
</html>