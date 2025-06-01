<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page</title>
</head>
<body>
<h2>Login Page</h2>

<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<p style="color:red;"><%= error %></p>
<% } %>

<form action="login" method="post">
  Enter name: <input type="text" name="username" required><br><br>
  Enter password: <input type="password" name="password" required><br><br>
  <input type="submit" value="Login">
</form>
</body>
</html>
