# Noteses WebApp

A simple yet professional notepad web application that allows users to sign up, log in, and manage their notes. With a clean and intuitive user interface, users can add, delete, and view notes with ease.

## Features

- **User Authentication**: 
  - Sign up, login, and logout functionality.
- **Note Management**: 
  - Create, read, and delete notes.
  - Each user has their own set of notes.
- **Professional Frontend**: 
  - A clean and minimal UI built with HTML, CSS, and JavaScript.
  - Smooth animations and form validation.

## Tech Stack

- **Backend**: Java, Jakarta Servlet
- **Frontend**: HTML, CSS, JavaScript (JSP for dynamic content rendering)
- **Database**: PostgreSQL
- **Web Server**: Apache Tomcat
- **Database Connectivity**: JDBC (Java Database Connectivity)

## Database Instructions

1. **Create the `users` table**:

    ```sql
    CREATE TABLE users (
        id SERIAL PRIMARY KEY,
        username VARCHAR(50) UNIQUE NOT NULL,
        password VARCHAR(255) NOT NULL
    );
    ```

2. **Create the `notes` table**:

    ```sql
    CREATE TABLE notes (
        id SERIAL PRIMARY KEY,
        user_id INT NOT NULL,
        title VARCHAR(255) NOT NULL,
        content TEXT NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
    );
    ```

## Project Directory Structure
Noteses/ 
│
├── src/
│   ├── main/
│   │   ├── java/                   
│   │   │   ├── db/
│   │   │   │   ├── DatabaseConnection.java         # Handles DB connection and setup
│   │   │   │   └── UserDAO.java                   # Handles user-related DB operations (signup, login)
│   │   │   │   └── NoteDAO.java                   # Handles note-related DB operations (create, read, update, delete)
│   │   │   │
│   │   │   ├── servlets/
│   │   │   │   ├── LoginServlet.java              # Handles login request
│   │   │   │   ├── SignupServlet.java             # Handles signup request
│   │   │   │   ├── NoteServlet.java               # Handles note-related requests (create, view, delete)
│   │   │   │   └── LogoutServlet.java  # Handles logout requests
│   │   │   │   └── TestServlet.java  # Test database connection
│   │   │   │
│   │   │   ├── models/
│   │   │   │   ├── User.java                      # User model (holds user details)
│   │   │   │   └── Note.java                      # Note model (holds note details)
│   │   │
│   │   └── webapp/             
│       │   ├── META-INF/
│       │   │   └── context.xml                    # DB connection configuration for the web app
│       │   │
│       │   ├── WEB-INF/
│       │   │   ├── web.xml                        # Servlet mapping and general web app configuration
│       │   │
│       │   ├── assets/            
│       │   │   ├── css/
│       │   │   │   ├── style.css                  # Main styles for the app
│       │   │   ├── js/
│       │   │   │   ├── validation.js  # Form validation (signup/login validation)
│       │   │   │   ├── animations.js  # Any animations, like fade-in/fade-out effects
│       │   │
│       │   ├── login.jsp                  # Login page
│       │   ├── signup.jsp                 # Signup page
│       │   ├── home.jsp                   # Main page after login (show all notes)
│       │   ├── addNote.jsp                     # Form for adding a note
│       │   └── index.jsp                          # Main entry point 

## Demo

You can watch a demo of the application here:  
[Demo Video](https://drive.google.com/file/d/1xvsykD3Ea0TAGcghWjY-YBVlHUNEpe0E/view)

## Dependencies

- Jakarta Servlet API
- PostgreSQL JDBC Driver
