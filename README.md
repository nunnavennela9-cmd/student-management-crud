# Student Management System (Java CRUD Application)

A console-based Student Management System built with core Java, JDBC, and MySQL. Implements full CRUD operations (Create, Retrieve, Update, Delete) with a menu-driven interface.

## Features
- Add a new student record
- View all student records
- Update a student's marks by ID
- Delete a student record by ID
- Search for a student by ID
- Looping menu until the user exits

## Technologies Used
- Java (Core Java, OOP)
- JDBC (Java Database Connectivity)
- MySQL (Database)
- PreparedStatements (to prevent SQL injection)

## How It Works
The application connects to a MySQL database using JDBC. Each menu option triggers a corresponding SQL query (INSERT, SELECT, UPDATE, DELETE) executed through PreparedStatements for safety.

## Setup
1. Create a MySQL database named `studentdb`
2. Create a `students` table with columns: id, name, course, marks
3. Update the database credentials in `DBConnection.java`
4. Run `StudentManagement.java`
