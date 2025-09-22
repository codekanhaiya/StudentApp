# ✅ Student App (Backend API)

A simple **Student Management Backend** built with **Java Spring Boot**, **Hibernate**, **JPA**, and **MySQL**, deployed on **Railway**.  
This app provides REST APIs to manage student records. Currently, it exposes an endpoint to fetch all students.

---

## 🚀 Features

- Built with **Spring Boot** (Java)
- **Hibernate + JPA** for database ORM
- **MySQL** for data persistence
- Hosted on **Railway**
- Provides RESTful API endpoints

---

## 📡 API Endpoint

### Get All Students

- **URL:**  
  [`https://studentapp-production-78ef.up.railway.app/students/getall`](https://studentapp-production-78ef.up.railway.app/students/getall)

- **Method:**  
  `GET`

- **Basic Authentication for User**
  `Username: user`
  `Password: user`

- **Basic Authentication for Admin**
  `Username: admin`
  `Password: admin`

- **Response Example:**

```json
[
  {
    "rollNo": "1",
    "name": "Amit Sharma",
    "course": "Computer Science"
  },
  {
    "rollNo": "10",
    "name": "Kavya Joshi",
    "course": "Artificial Intelligence"
  }
]
```

## 🛠️ Tech Stack

- Backend Framework: Spring Boot
- Database: MySQL
- ORM: Hibernate + JPA
- Hosting: Railway

---

## ⚙️ Installation (Local Setup)

### 1. Clone the repository:

```
git clone https://github.com/codekanhaiya/StudentApp.git
cd todo-app-backend
```

### 2. Configure your MySQL database in application.properties:

```
spring.datasource.url=jdbc:mysql://localhost:3306/studentappdb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and run the app:

```
./mvnw spring-boot:run
```

### 4. Access API at:

```
http://localhost:8080/students/getall
```

---

## 🚀 Live Demo

The project is deployed on **Railway** for quick access and testing:  
🔗 [Live API](https://studentapp-production-78ef.up.railway.app/students/getall)

---

## 👨‍💻 Author

Developed by **Kanhaiya Gupta** ✨
