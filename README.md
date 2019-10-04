# turvo-demo

Flash Sale APIs 

Projects Specs :

Platform : Java8  
Framework : SpringBoot  
Build tool : Gradle  

## Guidelines for Using the APIs :

Clone repository from Github using  below link :-   
&ensp; https://github.com/dheerajvats/turvo-demo.git
  

Move to project base location ( where settings.gradle file is present ).  
Open terminal/command prompt at base location and execute command 

gradle bootrun  

Now the project is up and APIs are available for testing.

## APIs Exposed :

POST : http://localhost:8082/turvo/services/addProduct  - Adds a new product according to the user input  

PUT : http://localhost:8082/turvo/services/startSale?saleId={saleId} - Starts a flash sale  

PUT : http://localhost:8082/turvo/services/endSale?saleId={saleId} - Stops a flash sale  

POST : http://localhost:8082/turvo/services/registerForSale - Allows a user to register for sale

POST : http://localhost:8082/turvo/services/orderProduct - Allows a registered user to place order  

## Implementation Details :

### ER Diagram :  

![TurvoDB](https://github.com/dheerajvats/turvo-demo/blob/master/Documents/TurvoDB.png)


### Business Logic :

* Only registered user can place order during a flash sale.  
* Registration to a sale is not allowed when the sale is active.  
* Register for the sale before it starts -> Start the sale -> Place order for the product on offer.  

### Postman collection link to test API :

https://www.getpostman.com/collections/9f10c2702e4aef3c2493
