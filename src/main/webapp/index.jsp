<%@ page import="javax.validation.ConstraintViolation" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: white;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            width: 400px;
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }

        .error-message {
            color: red;
            font-weight: bold;
            margin-bottom: 15px;
            text-align: center;
        }

        label {
            font-size: 14px;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            width: 100%;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .login-link {
            display: block;
            margin-top: 15px;
            text-align: center;
        }

        .login-link a {
            color: #007bff;
            text-decoration: none;
            font-size: 14px;
        }

        .login-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Signup</h1>

<%--    <% if (request.getAttribute("Error") != null) { %>--%>
<%--    <div class="error-message">--%>
<%--        <%= ((ConstraintViolation) request.getAttribute("Error")).getMessage() %>--%>
<%--    </div>--%>
<%--    <% } %>--%>

    <form action="signup" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <input type="submit" value="Sign Up">
        <small ><%= (request.getAttribute("Username exist") != null ? request.getAttribute("Username exist"): "")%></small>
        <small><%= (request.getAttribute("Error") != null ? ((ConstraintViolation) request.getAttribute("Error")).getMessage(): "")%></small>
    </form>

    <div class="login-link">
        <p>Already have an account? <a href="LoginServlet">Login</a></p>
    </div>
</div>
</body>
</html>
