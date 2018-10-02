# FWGreeter

This application is built using Java, the Spring Boot framework, Maven for the project management, MySQL for database management, Bootstrap for basic styling, and ThymeLeaf for displaying templates and dynamic information from Java objects.

This application allows users to receive a greeting once they sign in using their first and last name. Once they do sign in, they are persisted to a MySQL database that clears every start-up of the application. They are given a unique greeting based on if it is their first or last visit.

## Getting Started

Pull for the repo. Navigate to the /target folder and run the jar using java -jar nameOfjar [optional port].

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

Pull the repo and build with dependencies. Make sure to have MySQL installed. Run the SQL in: \src\main\resources\runthis.sql. This creates the database and the user that is configured for this application.