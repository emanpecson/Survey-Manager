# HOW TO START WEB-APP

## Requirements

- Java 17
- [Spring Boot (Maven)](https://docs.spring.io/spring-boot/docs/1.0.0.RC5/reference/html/getting-started-installing-spring-boot.html)
- Node.js
- [Angular CLI](https://angular.io/cli)

---

## 1. MySQL Database Setup

First, go to MySQL and create a local database.

Then open the following file to setup configurations to connect the database:

	Survey-Manager-Copy/src/main/resources/application.properties

- Replace `<DATABASE_NAME>` with the name of the database you created
- Replace `<YOUR_USER>` with user
- Replace `<YOUR_PASSWORD>` with password

---

## 2. Starting Back-end

Run the following file:

	Survey-Manager-Copy/src/main/java/com/demo/websurvey/WebsurveyApplication.java

This will launch the back-end server, which can be accessed at `localhost:8080`.

Running this file seems to work best when in an IDE, there should be a "play" button that runs the Java file and references the `Survey-Manager-Copy/pom.xml` file. So if lines from this file prompt errors (such that there are unknown import dependencies), try running `mvn clean install -U` in the `Survey-Manager-Copy/` directory. 

---

## 3. Starting Web-app

Go to the following directory:

	Survey-Manager-Copy/src/main/ui/

Then run the Angular command `ng serve -o` to launch the wep-app, which can be accessed at `localhost:4200`.

---

In order for the project to run, both the back-end server and web-app server must be launched. In case of disconnection, refer back to steps `2` and `3`.