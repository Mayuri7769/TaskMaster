# TaskMaster Backend

Task tracking backend system built with Spring Boot.

## Tech Stack
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- MySQL
- Maven

## Features
- User Registration
- User Login with JWT
- Create Task
- View Tasks
- Update Task
- Delete Task

## API Endpoints

POST /api/auth/register  
POST /api/auth/login  
POST /api/tasks/{userId}  
GET /api/tasks/{userId}  
PUT /api/tasks/{taskId}  
DELETE /api/tasks/{taskId}

## Run Project

1. Clone repo
2. Configure MySQL in `application.properties`
3. Run Spring Boot application