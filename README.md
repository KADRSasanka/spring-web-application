# ~ EVENT MANAGEMENT SYSTEM ~

_A modern Spring Boot + Thymeleaf + MySQL-based web application for managing events efficiently.
This system allows users to create, update, delete, view, analyze, and export event data with a clean dashboard interface._

## 🚀 Features

-User authentication & role management
-Dark mode toggle
-REST API integration

## 📌 Event Management

-Add new events
-Edit existing events
-Delete events
-View all events in a table
-Status-based badge system (Upcoming, Ongoing, Completed, Postponed, Cancelled, Draft)
-Event filtering & search

## 📊 Dashboard

-Doughnut chart showing event status distribution
-Announcement panel
-Latest events section
-Paginated events table (5 rows per page)

## 📤 Export

-Export events to Excel (.xlsx)

## 🎨 UI Features

* Modern UI design
* Hover animations
* Responsive layout (Bootstrap 5)
* Status-based color coding

## 🛠️ Technologies Used

1. Java
2. Spring Boot
3. Spring MVC
4. Spring Data JPA
5. Thymeleaf
6. MySQL (XAMPP)
7. Bootstrap 5
8. Chart.js
9. Apache POI (Excel Export)

## ⚙️ System Requirements

1. Java 17+ (recommended)
2. Maven
3. XAMPP (MySQL)
4. IDE (IntelliJ / VS Code)

## 🔗 Clone Project from GitHub (HTTPS) Using IntelliJ Terminal

This guide explains how to clone the project using HTTPS inside IntelliJ IDEA.

### ✅ Prerequisites

Git installed → Check: git --version
IntelliJ IDEA installed
GitHub account

### 🚀 Method 1: Clone Using IntelliJ Terminal (HTTPS)

1️⃣ Copy HTTPS URL from GitHub

Go to your GitHub repository.
Click the Code button.
Select HTTPS.
Copy the URL:
	https://github.com/KADRSasanka/spring-web-application.git

2️⃣ Open IntelliJ Terminal

In IntelliJ:
View → Tool Windows → Terminal

3️⃣ Navigate to Desired Folder

Example:
cd Desktop

4️⃣ Clone the Repository
git clone https://github.com/KADRSasanka/spring-web-application.git

5️⃣ Open the Project
cd spring-web-application

Or:
	File → Open → Select the cloned folder

🔐 If GitHub Asks for Authentication

GitHub no longer supports password authentication.

Use:
Personal Access Token (PAT) instead of a password

Create token:
	GitHub → Settings → Developer Settings → Personal Access Tokens → Generate New Token

Use that token as your password when prompted.

### 🔄 Setup IntelliJ with GitHub (Version Control Integration)

This section explains how to connect IntelliJ IDEA with GitHub directly.

✅ Step 1: Enable Version Control in Project

-Open your project in IntelliJ.
-Go to: 
	VCS → Enable Version Control Integration
-Select: 
	Git
-Click OK

✅ Step 2: Add GitHub Account to IntelliJ

-Go to:
	File → Settings → Version Control → GitHub
-Click +
-Log in using:
	GitHub Account
	OR Token
-Click Test to verify the connection.

✅ Step 3: Share Project to GitHub (First Time)

If the project is not yet on GitHub:
-Go to:
	Git → GitHub → Share Project on GitHub
-Enter:
	Repository Name
	Description
	Visibility (Public/Private)
-Click Share

✅ Step 4: Push Code Manually (If Needed)

If the repository already exists:

Add Remote
	git remote add origin https://github.com/KADRSasanka/spring-web-application.git

Add Files
	git add .

Commit
	git commit -m "Initial commit."

Push
	git push -u origin main

## 🔄 Basic Git Workflow (Daily Use)

After making changes:
	git add .
	git commit -m "Updated feature."
	git push

To get the latest changes:
	git pull origin main

## 🧠 Recommended IntelliJ Git Settings

Go to:
	File → Settings → Version Control → Git
Ensure:
	Git executable path is correct
Test button shows success

## 🗄️ Database Setup (MySQL via XAMPP)

1️⃣ Start MySQL in XAMPP

Open XAMPP → Start Apache and MySQL

2️⃣ Create Database

Go to http://localhost/phpmyadmin/

Create a new database:
	CREATE DATABASE spring_web_app;

3️⃣ Configure application.properties

spring.application.name=spring-web-application

spring.datasource.url=jdbc:mysql://localhost:3306/spring_web_app?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

## ▶️ How to Run the Project

Option 1 – Using an IDE

Open project in IntelliJ / Eclipse
Maven → Reload project
Run:
	SpringWebApplication.java
Open browser:
	http://localhost:8080
Add Credentials:
	UserName - admin@email.com
	Password - admin123

## 📊 Dashboard Features

Doughnut chart displaying:
* Upcoming (Info)
* Ongoing (Primary)
* Completed (Success)
* Postponed (Warning)
* Cancelled (Danger)
* Announcement section beside chart
* Modern card-based layout

## Admin Features

Only ADMIN role users can have access to ADMIN page.
ADMIN button is disabled to USER role users 

## 📋 Event Table Features

Displays:
* Event Code
* Event Name
* Venue
* Project Chair
* Status
* Status badges with Bootstrap colors
* Pagination (5 rows per page)
* Excel export support

## 📤 Excel Export

Events can be exported as:
.xlsx file

Generated using Apache POI.

## 📌 Project Type

Academic / Portfolio Project
Built for learning and demonstration of:
-Spring Boot MVC
-CRUD operations
-Dashboard UI
-Database integration
-Excel export functionality

## 🧠 Learning Outcomes

-MVC architecture implementation
-Thymeleaf dynamic rendering
-MySQL integration
-Chart.js integration with backend data
-Pagination handling
-File export handling
