# HOW TO START WEB-APP

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

This will launch the back-end server at `localhost:8080`.

---

## 3. Starting Web-app

Go to the following directory:

	Survey-Manager-Copy/src/main/ui/

Then run the Angular command `ng serve -o` to launch the wep-app at `localhost:4200`.
