# REST API Challlenge

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
  
    mvn clean package : to build the project
    
    mvn spring-boot:run : to start the project 

    java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5000 -jar target/XXXX.jar : to start in debug mode on port 5000.
Follow this link to set up remote connection (http://javarevisited.blogspot.ca/2011/02/how-to-setup-remote-debugging-in.html)

You can test services with OpenAPI at the following url http://localhost:8090/swagger-ui.html

h2 database can be accessed at the following url http://localhost:/h2-console/, Default user=sa, password password.
