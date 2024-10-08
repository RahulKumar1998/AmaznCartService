# AmaznCartService
# AmaznCart Project

A Spring Boot-based eCommerce application that supports product inventory management with discounts and promotion sets logic.

## Prerequisites
- Java 17 or higher
- Spring Boot 3.0 and higher
- Maven
- MySQL 8.0 and higher installed on the local machine

## Setup

### 1. Clone the repository
```bash
git clone https://github.com/RahulKumar1998/AmaznCartService.git
cd amazncart
```
### 2. MySQL Database Setup
* Install MySQL: [Download MySQL](https://dev.mysql.com/downloads/installer/])
* Start MySQL server at port : 3306

### 3. Compile and Run the Application
```bash
mvn clean install -DskipTests
```
* Run the Application using the IDE or:
```bash
mvn spring-boot:run
```
* Check the logs and confirm the application is running on the embedded Tomcat Server at port : 8080

### 4. Test the REST APIs
* Test of Get API:
![test_get_api_using_postman.png](test_get_api_using_postman.png)