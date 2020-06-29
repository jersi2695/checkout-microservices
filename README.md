# Microservices Test

## Installation

Move to the folder `/commons-service` and execute `mvn install`

Then, go to the services folders and execute the follow command `mvn clean package` to create a jar and an images for the service with the help of dockerfile-maven-plugin. 

After build the projects and create the images, use the file `docker-compose.yml` in the root of the repository and execute this command `docker-compose up` to up the containers for the images.

You can see the documentation for the checkout service in this url `http://localhost:8090/checkout/swagger-ui.html`


## Design

The solution has 4 main microservices:

- `order-service` stores the order and the products asscoiated to the order.
- `bill-service` creates a bill from an order and calculates the total for the order.
- `logistic-service` creates a sent order, where it stores the orderId and calculate the dispatch date, by default 4 days after the sent order is created.
- `checkout-service` manages all the operation for checkout, and uses the other microservices to execute the buissness logic.

There are two more general service:

- `eureka-server` works to naming and discovery server to allow communicate beetween service without knowing the exact service's url.
- `zuul-server` works as a gateway, this server allows me to expose as public the `checkout-service` and hold the others services hidden
