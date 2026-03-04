🧠 Interview Portal 
A Full Stack Interview Preparation Portal built using Spring Boot, MySQL, HTML, CSS, and JavaScript.

This application allows users to:
Register & Login
Attempt topic-based MCQ quizzes
Submit answers
View final score

🚀 Tech Stack
🔹 Backend
Java
Spring Boot
Spring Data JPA
MySQL
REST APIs
🔹 Frontend
HTML
CSS
JavaScript (Fetch API)

📂 Project Structure
com.example.Interview_Portal
│
├── Controller
│   ├── Auth_Controller.java
│   └── Question_Controller.java
│
├── Service
│   ├── Auth_Service.java
│   └── Question_Service.java
│
├── Repository
│   ├── User_Repo.java
│   └── Question_Repo.java
│
├── Entity
│   ├── User_Entity.java
│   └── Question_Entity.java
│
└── InterviewPortalApplication.java
📌 Features
🔐 Authentication Module
User Registration
User Login
Stores user data in MySQL database

📝 MCQ Quiz Module
Topic-based quizzes:
Java Full Stack
AI & ML
5 random questions per quiz
Submit answers
Score calculation
Display final result (Score / 5)
🗄️ Database Configuration

Update your application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/interview_portal
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

📡 REST API Endpoints
🔐 Auth APIs
Register User
POST /auth/register
Example JSON:

{
  "username": "jeevi",
  "password": "1234"
}
Login User
POST /auth/login
📝 Question APIs
Add Question
POST /questions/add
Example:

{
  "question": "Which framework is used for Java backend?",
  "optionA": "React",
  "optionB": "Spring Boot",
  "optionC": "Angular",
  "optionD": "Vue",
  "correctOption": "B",
  "topic": "Java-Full-Stack"
}
Get Quiz Questions by Topic
GET /questions/{topic}/quiz

Example:
GET /questions/Java-Full-Stack/quiz
Submit Answer
POST /questions/submit?id={questionId}&userAns={A/B/C/D}
▶️ How to Run the Project
1️⃣ Clone the Repository
git clone https://github.com/your-username/Interview-Portal.git
2️⃣ Setup MySQL Database
Create database:
CREATE DATABASE interview_portal;

3️⃣ Run Backend
Open project in IntelliJ / Eclipse
Run InterviewPortalApplication.java
Server runs at:
http://localhost:8080
4️⃣ Run Frontend
Open index.html
Select topic
Attempt quiz
View final score 🎉
Updated UI and changed background for better experience and improvements

🎯 Future Improvements
JWT Authentication
Password Encryption
Quiz Timer
React Frontend
Deployment (Render / Railway / AWS)
