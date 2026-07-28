# 📚 AI Study Habit Analyzer

An AI-powered web application built with **Spring Boot**, **Thymeleaf**, and **MySQL** that helps students track their study habits, analyze productivity, maintain study streaks, and receive personalized study recommendations.

---

## 🚀 Features

### 🔐 User Authentication
- User Registration
- Secure Login & Logout
- Session-based Authentication

### 📖 Study Session Management
- Add new study sessions
- Record:
  - Subject
  - Study Hours
  - Productivity Score
  - Study Date

### 📊 Dashboard Analytics
- Total Study Hours
- Current Study Streak
- Total Subjects Studied
- Average Productivity
- Weekly Study Analytics Chart
- Recent Study Sessions

### 🤖 AI Study Recommendations
- Identifies Best Performing Subject
- Identifies Weakest Subject
- Suggests personalized improvement tips

### 📈 Data Visualization
- Weekly Study Analytics using Chart.js
- Dynamic Dashboard
- Responsive UI

---

# 🛠️ Tech Stack

| Technology | Used |
|------------|------|
| Java | ✔ |
| Spring Boot | ✔ |
| Spring MVC | ✔ |
| Spring Data JPA | ✔ |
| Thymeleaf | ✔ |
| MySQL | ✔ |
| Bootstrap 5 | ✔ |
| Chart.js | ✔ |
| Maven | ✔ |

---

# 📂 Project Structure

```
StudyHabitAnalyzer
│
├── src/main/java
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   └── StudyHabitAnalyzerApplication.java
│
├── src/main/resources
│   ├── templates
│   ├── static
│   │   ├── css
│   │   ├── js
│   │   └── images
│   └── application.properties
│
└── pom.xml
```

---

# ⚙️ Installation Guide

## 1. Clone Repository

```bash
git clone https://github.com/yourusername/AI-Study-Habit-Analyzer.git
```

---

## 2. Open Project

Open the project using:

- Eclipse
- IntelliJ IDEA
- VS Code

---

## 3. Configure MySQL

Create a database.

```sql
CREATE DATABASE study_analyzer;
```

Update your **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/study_analyzer
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

---

## 4. Install Dependencies

Maven automatically downloads dependencies.

Or run

```bash
mvn clean install
```

---

## 5. Run the Application

Run

```
StudyHabitAnalyzerApplication.java
```

or

```bash
mvn spring-boot:run
```

---

## 6. Open Browser

```
http://localhost:8080
```

---

# 📸 Application Workflow

### Register

Create a new account.

↓

### Login

Login using your registered credentials.

↓

### Dashboard

View

- Total Study Hours
- Current Streak
- Subjects Studied
- Productivity Score
- Weekly Analytics
- AI Recommendations

↓

### Add Study Session

Enter

- Subject
- Hours Studied
- Productivity Score
- Study Date

↓

### Dashboard Updates Automatically

Statistics and charts refresh based on stored study sessions.

---

# 🗄️ Database

Main Tables

- User
- StudySession

Each study session stores

- Subject
- Hours
- Productivity
- Date
- User ID

---

# 🎯 Key Functionalities

- User Authentication
- Study Session Tracking
- Dashboard Analytics
- Weekly Study Graph
- Study Streak Calculation
- Productivity Analysis
- AI Recommendation Engine

---

# 📈 Future Enhancements

- Spring Security Authentication
- JWT Login
- Password Encryption
- Email Notifications
- Daily Study Reminders
- Goal Tracking
- AI Study Planner
- Export Reports as PDF
- Dark Mode
- Mobile Application

---

# 👨‍💻 Author

**Ritesh Dalal**

Final Year B.E. (Artificial Intelligence & Machine Learning)

GitHub:
https://github.com/yourusername

LinkedIn:
https://linkedin.com/in/yourprofile

---

# ⭐ Support

If you found this project helpful, please consider giving it a ⭐ on GitHub.
