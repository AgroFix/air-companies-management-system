![AIR COMPANY MANAGEMENT SYSTEM](https://upload.wikimedia.org/wikipedia/commons/f/fc/Tarom.b737-700.yr-bgg.arp.jpg)
# ✈️ AIR COMPANY MANAGEMENT SYSTEM ✈️
___
## 👋 Introduction 👋
Welcome to the air company management system.  
This is my implementation of the Synergy Way test case.
___
## 🌐 Technology stack 🌐
* Programming Language: Java
* Application Configuration: Spring Boot, Spring, Maven
* Accessing Data Spring Data: JPA, Hibernate, MySQL
* Web Development: Spring MVC, Servlets, Tomcat
* Documentation:Swagger
* Version Control: Git
___
## 💻 Functionality 💻
1. **Air Company Controller**:
    - POST: /api/air_companies - Create a new air company
    - GET: /api/air_companies - Retrieve all air companies
    - GET: /api/air_companies/{id} - Retrieve an air companies by id
    - PUT: /api/air_companies/{id} - Update an air company by id
    - DELETE: /api/air_companies/{id} - Delete an air company by id

2. **Airplane Controller**
    - POST: /api/airplanes - Create a new airplane
    - PUT: /api/airplanes/{id} - Move airplane between companies
   
3. **Flight Controller**:
    - POST: /api/flights - Create a new flight
    - GET: /api/flights/active - Retrieve all active flight and started more than 24 hours ago
    - GET: api/flights/status?status={status}&CompanyName={CompanyName} - Retrieve all flight by status and air company name
    - PUT: /api/flights/{id}?newStatus={newStatus} - Update flight status
___
## 👨‍🚀 Ability to send requests to the endpoints by Postman 👨‍🚀
Moreover, you can try sending requests to the endpoints using Postman by clicking [here](https://www.postman.com/gold-resonance-796764/workspace/air-company-management-system/collection/20663708-72512730-8134-4f17-be10-b3a8d6c83403?action=share&creator=33964543).
It's a collection of prepared requests where you can test functionality of the controllers.
___
## 🧰 Setup Instructions 🧰
1. Clone repository: clone from the console with the command:   
```git clone https://github.com/AgroFix/air-companies-management-system.git```
2. Check database setup: Customize the database settings in the application.properties file.
3. Build and run project: mvn spring-boot:run
___
## 🐳 Running with Docker Compose 🐳
If you prefer to run the air company management system in a Docker container using Docker Compose, follow these steps:

1. Clone repository: Clone the repository from the console with the command:   
``` git clone https://github.com/AgroFix/air-companies-management-system.git```

2. Check Docker Compose file: Ensure that the docker-compose.yml file in the root of the project is configured appropriately. You can customize environment variables, ports, and other settings in this file.

3. Build and run the project: Execute the following commands in the project root directory:
   ```bash
   docker-compose build
   docker-compose up
___
## 💟 Thanks 💟
Thank you for reading to the end, Good Luck!!! 🌈

![App Screenshot](https://gifsec.com/wp-content/uploads/2022/10/good-luck-gif-1.gif)