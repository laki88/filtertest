# filtertest

servlet filter test application

This is a sample application to demonstrate capability of servlet filter. 
In client request authenticated username and user-name http header are equal, 
then request will pass through the filter and will receive by controller. controller will send 
a sample response to the client. Otherwise, request will not receive by controller and empty response 
will receive by client.

###Prerequisites
Install the following requirements to run the project
1. Java 11
2. maven

### Building the project
```
set JAVA_HOME=D:\software\jdk-11
set PATH=D:\software\jdk-11\bin;%PATH%
mvn clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true
```
### Run the project
Either first or second way can be used to run the project

1. Open the project in Intellij Idea or Eclipse and run the main function in FilterTestApplication.
2. Run with Following command in terminal 
```
mvn spring-boot:run
```
Open the postman collection in project root with postman and run the request

sample users
```
user : admin, password:admin
user : lakshman, password: 123
```