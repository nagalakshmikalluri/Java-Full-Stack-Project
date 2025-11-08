# 🧩 Java Full Stack Job Portal Project

This is a **Full Stack Job Portal Application** built using **Spring Boot (Backend)** and **React + Vite (Frontend)**.  
The platform allows job seekers to register, log in, and apply for jobs, while employers can post new job listings.

---

## 🚀 Tech Stack

### 🔧 Backend
- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Security & JWT Authentication**
- **Spring Data JPA (Hibernate)**
- **MySQL Database**

### 💻 Frontend
- **React 18 (Vite)**
- **Axios** for API requests
- **TailwindCSS** for styling *(optional)*

---

## 🌟 Features

✅ User Registration & Login (with password encryption)  
✅ JWT-based Authentication & Authorization  
✅ Post and View Jobs  
✅ Apply for Jobs (Job Seeker)  
✅ Manage Applications (Admin / Employer)  
✅ RESTful API built with Spring Boot  
✅ Responsive React UI for users

---

## 🗂️ Project Structure
Java-Full-Stack-Project/
│
├── backend/ # Spring Boot backend
│ ├── src/main/java/com/jobportal/backend/
│ │ ├── controller/ # REST Controllers
│ │ ├── config/ # Security & JWT Configuration
│ │ ├── model/ # Entity Classes
│ │ ├── repository/ # JPA Repositories
│ │ └── dto/ # Data Transfer Objects
│ └── resources/
│ └── application.properties
│
├── client/ # React frontend
│ ├── src/
│ │ ├── pages/ # React pages (Login, Register, Jobs, etc.)
│ │ ├── services/ # Axios API setup
│ │ └── App.jsx
│ └── vite.config.js
│
└── README.md
