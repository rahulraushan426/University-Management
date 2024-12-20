#University Management System
##This Project is under development.
This repository contains the code for a University Management System built using Java and MySQL. The application aims to streamline the management of students, courses, faculty, and administrative tasks. The project follows an MVC architecture, ensuring easy scalability and maintainability. Built using Java Servlets, JSP, and MySQL, the system provides a robust solution for managing various aspects of university operations.

#Features
Student Management: Register, update, view, and delete student records.
Login/Logout: Secure user login/logout.
User Profile: View and update user profiles.
Technology Stack
##Frontend
--JSP (JavaServer Pages)
--HTML5
--CSS3
--JavaScript
--Bootstrap 4.5.2
##Backend
--Java Model classes
--Java DAO classes
--Java Servlets
--JDBC
--MySQL 8.0
##Tools & Libraries
--Maven
--jQuery
--Font Awesome
--MySQL Connector/J
##Prerequisites
--JDK 11 or higher
--Apache Tomcat 9.0 or higher
--MySQL 8.0
--Maven 3.x
--IDE (Eclipse/IntelliJ IDEA)
##Database Setup
#1. Create a new MySQL database:
--Refer to schema.sql for the database schema.
#2. Create the required tables:
--Refer to schema.sql for the table structure.
##Installation & Setup
#1. Clone the repository:
--bash
--Copy code
--git clone https://github.com/YourUsername/University-Management.git
#2. Configure database connection:
--Open src/main/java/com/user/dao/UserDAO.java
--Update the database URL, username, and password in other DAO classes accordingly.
#3. Build the project:
--bash
--Copy code
--mvn clean install
#4. Deploy to Tomcat:
--Copy the WAR file target/university-management.war to Tomcat's webapps directory.
--Start Tomcat server.
#5. Access the application:
--http://localhost:8080/university-management
