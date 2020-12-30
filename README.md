# REST API Challlenge

## Pre-Requisite

Java 8 or 11.

Maven 3.6.3

We use h2 in-memory database to eliminate the need for istalling and configuring an actual database.
## REST API Endpoints

### Booking endpoints

   GET /bookings, get all reservations
  
   POST /bookings, create a reservation
  
   PUT /bookings, update reservations
  
   DELETE /bookings, cancel reservations
  
### User endpoints
  
   POST /users, create user
  
   DELETE /users, delete user and all associated reservations
  

## Run REST API challenge 
  Build and run project from command line :
  
    mvn clean package : to build the project and run integration tests
    
    mvn spring-boot:run : to start the project 


You can test services with OpenAPI at the following url http://localhost:8090/swagger-ui.html

h2 database console can be accessed at the following url http://localhost:/h2-console/, Default user=sa, password password.

## Room for improvement

Unit tests for better code coverage
