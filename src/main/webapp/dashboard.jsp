<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/24/2024
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to bottom right, #6a11cb, #2575fc);
            color: white;
            text-align: center;
        }
        .container {
            padding: 50px;
        }
        .welcome {
            font-size: 36px;
            margin: 20px 0;
        }
        .info {
            font-size: 20px;
            margin: 15px 0;
        }
        .btn {
            display: inline-block;
            margin-top: 20px;
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
    <h1 class="welcome">Welcome to Your Dashboard!</h1>
    <p class="info">Hello <strong>${sessionScope.username}</strong>, we're glad to see you here.</p>
    <p class="info">You can explore more features or manage your profile.</p>
    <a href="profile.jsp" class="btn">View Profile</a>
    <a href="logout" class="btn" style="background: #ff4c4c;">Logout</a>
</div>
</body>
</html>

