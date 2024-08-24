<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        form {
            max-width: 100%;
            margin: 0 auto;
            border: 2px solid #000;
            padding: 20px;
  			width: 300px; 
        }
        
        input{
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        button {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: white;
        }

        button:hover {
            background-color: #218838;
        }
    </style>
    
</head>
<body>

    <h2 style="text-align: center">Admin Login</h2>
    <form action="login" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>

    <%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.isEmpty()) { %>
    <%= errorMessage %>
	<% } %>
	
</body>
</html>

