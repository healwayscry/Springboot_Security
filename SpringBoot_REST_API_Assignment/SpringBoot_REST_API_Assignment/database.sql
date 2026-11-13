CREATE DATABASE IF NOT EXISTS spring_api_db
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE spring_api_db;

-- Spring Boot/JPA will create/update tables automatically in the DEV profile.
-- After the application starts, verify:
SHOW TABLES;

-- Expected tables:
-- students
-- courses
-- enrollments
