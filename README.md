# REST API Challlenge

## REST API Endpoints

### Booking endpoints

   GET /bookings
  
   POST /bookings
  
   PUT /bookings
  
   DELETE /bookings
  
### User endpoints

   GET /users
  
   POST /users
  
   PUT /users
  
   DELETE /users
   
## Run REST API challenge 
  Build and run project from command line :
  
    mvn clean package : to build the project
    
    mvn spring-boot:run : to start the project 

    java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5000 -jar target/XXXX.jar : to start in debug mode on port 5000.
Follow this link to set up remote connection (http://javarevisited.blogspot.ca/2011/02/how-to-setup-remote-debugging-in.html)

You can test services with swagger at the following url http://localhost:8080/swagger-ui.html