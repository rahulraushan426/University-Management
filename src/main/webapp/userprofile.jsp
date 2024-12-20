<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile - Galgotias University</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>Welcome to Your Profile</h1>
    </header>

    <nav>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="editprofile.jsp">Edit Profile</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>

    <section class="profile-container">
        <h2>Your Profile Information</h2>
        
        <!-- Displaying user information from session or database -->
        <div class="profile-info">
            <p><strong>Name:</strong> <span>${user.name}</span></p>
            <p><strong>Roll Number:</strong> <span>${user.rollno}</span></p>
            <p><strong>Email:</strong> <span>${user.email}</span></p>
        </div>

        <footer>
            <p>&copy; 2024 Galgotias University. All rights reserved.</p>
        </footer>
    </section>
</body>
</html>
