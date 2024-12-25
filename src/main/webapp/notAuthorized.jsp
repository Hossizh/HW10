<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/24/2024
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Access Forbidden</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to bottom right, #ff4e50, #f9d423);
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            text-align: center;
        }
        .container {
            padding: 20px;
            max-width: 500px;
            background: rgba(0, 0, 0, 0.5);
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }
        .title {
            font-size: 36px;
            font-weight: bold;
            margin-bottom: 20px;
        }
        .message {
            font-size: 18px;
            margin-bottom: 30px;
        }
        .btn {
            display: inline-block;
            margin-top: 10px;
            padding: 15px 30px;
            font-size: 16px;
            color: #fff;
            background: #ff7a59;
            border: none;
            border-radius: 25px;
            text-decoration: none;
            transition: background 0.3s ease;
        }
        .btn:hover {
            background: #ff5722;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="title">Access Forbidden</h1>
    <p class="message">You do not have permission to access this page.</p>
    <a href="login.jsp" class="btn">Go to Login</a>
</div>
</body>
</html>

