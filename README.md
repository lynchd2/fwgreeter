# FWGreeter

This application is built using Java, the Spring Boot framework, Maven for project management, MySQL for database management, Bootstrap for basic styling, and ThymeLeaf for displaying templates and dynamic information from Java objects.

This application allows users to receive a greeting once they sign in using their first and last name. Once they do sign in, they are persisted to a MySQL database that clears every start-up of the application. They are given a unique greeting that is determined whether or not they have visited before.

## Getting Started

Pull for the repository. Navigate to the /target folder and run the jar using java -jar nameOfjar [optional port].


### Installing

Pull the repo and build with dependencies. Make sure to have MySQL installed. Run the SQL in: \src\main\resources\runthis.sql. This creates the database and the user that is configured for this application.