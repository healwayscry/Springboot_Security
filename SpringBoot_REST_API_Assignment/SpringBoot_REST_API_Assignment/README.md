# Spring Boot REST API + MySQL + JPA/Hibernate

## Requirements covered
- Spring Boot
- Maven
- Configuration
- DEV / PROD profiles
- REST API: GET, GET/{id}, POST, PUT/{id}, DELETE/{id}
- MySQL
- JPA/Hibernate
- 3 entities
- Entity relationships

## Entities
1. Student
2. Course
3. Enrollment

Relationships:
- Student 1 --- N Enrollment
- Course 1 --- N Enrollment
- Enrollment N --- 1 Student
- Enrollment N --- 1 Course

## Run
1. Create database:
   `CREATE DATABASE spring_api_db;`
2. Check MySQL username/password in `application-dev.properties`.
3. Run:
   `mvn spring-boot:run`
4. API base URL:
   `http://localhost:8080/api`

## Endpoints
### Students
GET    /api/students
GET    /api/students/{id}
POST   /api/students
PUT    /api/students/{id}
DELETE /api/students/{id}

### Courses
GET    /api/courses
GET    /api/courses/{id}
POST   /api/courses
PUT    /api/courses/{id}
DELETE /api/courses/{id}

### Enrollments
GET    /api/enrollments
GET    /api/enrollments/{id}
POST   /api/enrollments
PUT    /api/enrollments/{id}
DELETE /api/enrollments/{id}

## Sample POST Student
{
  "name": "Nguyen Van A",
  "email": "a@example.com",
  "major": "Information Technology"
}

## Sample POST Course
{
  "name": "Advanced Programming",
  "code": "IT302",
  "credits": 3
}

## Sample POST Enrollment
Use IDs returned by the Student and Course POST requests:
{
  "student": {"id": 1},
  "course": {"id": 1},
  "enrolledAt": "2026-11-06",
  "score": 8.5
}
