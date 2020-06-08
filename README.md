# JHipster with a Microservice Architecture
JHipster is, in a nutshell, a high-level code generator built upon an extensive list of cutting-edge development tools and platforms.

The main components of the tool are:

Yeoman, a front-end scaffolding tool
Good old Spring Boot
AngularJS, the prominent Javascript framework. JHipster also works with AngularJS 
## JHipster Microservice Components
When working on a Microservice architecture with JHipster, we'll need to build and deploy at least three different projects: a JHipster Registry, a Microservice Gateway, and at least one Microservice Application.

- The JHipster Registry is an essential piece of the microservice architecture. It ties all the other components together and enables them to communicate with each other.

- The Microservice Application contains the back-end code. Once running it will expose the API for the domain it is concerned with. A Microservice Architecture may be composed of many microservice applications, each containing a few related entities and business rules.

- And the Microservice Gateway has all the front-end (Angular) code and will consume the API created by the whole group of micro service applications:

## Installing JHipster Registry

Since the JHipster Registry is a standard JHipster, so we just need to download and run it. There is no need to modify it:

```
git clone https://github.com/jhipster/jhipster-registry
cd jhipster-registry && ./mvnw
```
This will clone the jhipster-registry project from GitHub and start the application. Once it successfully starts up, we can visit http://localhost:8761/ and log in with user admin and password admin.

## Installing a Microservice Application
Here is where we start to build the actual features of our project. In this example, we'll create a simple Microservice Application that manages cars. So first we'll create the application, and then we'll add an entity to it.
```
# create a directory for the app and cd to it
mkdir car-app && cd car-app
# run the jhipster wizard
yo jhipster
```
Once the wizard starts, let's follow the instructions to create a Microservice type application named carapp. Some other relevant parameters are:

port: 8081
package: com.car.app
authentication: JWT
service discovery: JHipster Registry

Now we'll add a car entity to our application:
```
# runs entity creation wizard
yo jhipster:entity car
```
The entity creation wizard will start. We should follow the instructions to create an entity named the car with three fields: make, model, and price.

Once that's finished, our first Microservice application is complete. If we have a look at the generated code, we'll notice that there's no javascript, HTML, CSS or any front-end code. Those will all be produced once the Microservice Gateway is created. Also, check out the README file for important information about the project and useful commands.

To finish up, let's run our newly created component-

```
./mvnw
```
Before running the above command, we should ensure that the jhipster-registry component is up and running. Otherwise, we'll get an error.

If everything went according to plan, our car-app would start, and the jhipster-registry log will tell us that the app was successfully registered:

```
Registered instance CARAPP/carapp:746e7525dffa737747dcdcee55ab43f8
  with status UP (replication=true)
  ```
  
## Installing a Microservice Gateway
Now the front-end bit. We'll create a Microservice Gateway and indicate to it that we have an entity on an existent component for which we want to create the front-end code:

```
# Create a directory for our gateway app
mkdir gateway-app && cd gateway-app
# Runs the JHipster wizard
yo jhipster
```
Let's follow the instructions to create an application of type Microservice gateway. We'll name the application gateway, and select the following options for the other parameters:

port: 8080
package: com.gateway
auth: JWT
service discovery: JHipster Registry

Let's move on to entity creation:

```
# Runs entity creation wizard
yo jhipster:entity car
```

When asked if we want to generate from an existent microservice, choose Yes, then type in the relative path to the car-app root directory (ex.: ../car-app). Finally, when asked if we want to update the entity, choose Yes, regenerate the entity.

JHipster will find the Car.json file which is part of the existent Microservice Application we've created earlier and will use the metadata contained in that file to create all the necessary UI code for that entity:

```
Found the .jhipster/Car.json configuration file, entity can be automatically generated!
```

Time to run the gateway-app and test if everything is working:

```
# Starts up the gateway-app component
./mvnw
```

Let's now navigate to http://localhost:8080/ and log in with user admin and password admin. On the top menu, we should see an item Car that will take us to the car list page. All good!
