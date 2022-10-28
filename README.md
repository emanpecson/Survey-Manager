# **PROJECT OVERVIEW**

## **Description**

The **Survey Manager** is a web-app that allows users to create basic surveys with ease. All created surveys can be managed at the home screen. From there, users can choose to
- submit a survey attempt,
- view survey results, 
- or delete the survey from the database.

---

## **Brief Technical Implementation**

### **Back-end**

This app uses `Spring Boot` to easily 
- design a RESTful API, 
- configure the project with a given database, 
- and manage table entities. 

`Java` files of interest can be found under:

	Survey-Manager/src/main/java/com/demo/websurvey/


### **Front-end**

This app uses `Angular` to manage the user-interface and experience with 
- multi-page routing, 
- HTTP requests to back-end, 
- and various forms of grabbing user-input.

`TypeScript, HTML, and CSS` files of interest can be found under:

	Survey-Manager/src/main/ui/src/app/

---

# **LOCAL SETUP**

## **Requirements**

- Java 17
- MySQL
- [Spring Boot (Maven)](https://docs.spring.io/spring-boot/docs/1.0.0.RC5/reference/html/getting-started-installing-spring-boot.html)
- Node.js
- [Angular CLI](https://angular.io/cli)

---

## **1. MySQL Database Setup**

First, go to MySQL and create a local database.

Then open the following file to setup configurations to connect the database:

	Survey-Manager/src/main/resources/application.properties

- Replace `<DATABASE_NAME>` with the name of the database you created
- Replace `<YOUR_USER>` with user
- Replace `<YOUR_PASSWORD>` with password

---

## **2. Starting Back-end**

Run the following file:

	Survey-Manager/src/main/java/com/demo/websurvey/WebsurveyApplication.java

This will launch the back-end server, which can be accessed at `localhost:8080`.

Running this file seems to work best when in an IDE, there should be a "play" button that runs the Java file and references the `Survey-Manager/pom.xml` file. So if lines from this file prompt errors (such that there are unknown import dependencies), try running `mvn clean install -U` in the `Survey-Manager/` directory. 

---

## **3. Starting Web-app**

Go to the following directory:

	Survey-Manager/src/main/ui/

Then run the Angular command `ng serve -o` to launch the wep-app, which can be accessed at `localhost:4200`.

---

In order for the project to run, both the back-end server and web-app server must be launched. In case of disconnection, refer back to steps `2` and `3`.