# Roman Number
A SpringBoot Application providing an endpoint that can convert an integer to a roman number.

# Build And Run
## Build With
  * Maven
  * Java 8
## How to Run
  1. clone the project `git clone https://github.com/XingxingLi2017/romannumber.git`
  2. run maven pacakge command `mvn pacakge`
  3. run springboot application with java command `java -jar .\target\romannumber.jar`
  4. open the browser and access url `http://localhost:8080/romannumeral?query=3999`, if everything goes smoothly, you can see the JSON response like this 
  ![Response](https://github.com/XingxingLi2017/romannumber/blob/master/img/response.png)
  5. open the browser and access url `http://localhost:8080/romannumeral?query=-1`, you can get an error message like this
  ![Error](https://github.com/XingxingLi2017/romannumber/blob/master/img/outofrangeerror.png)
## How to deploy application in docker container
  * Environment: 
    * Ubuntu 20.04.1
    * Docker 20.10.7
    * Maven 3.2+
    * JDK 1.8
  1. build docker image `sudo mvn clean package docker:build`
  2. check docker image `sudo docker images`
  3. run docker container `sudo docker run -p 8080:8080 -t romannumber/romannumber`
  4. access url `http://remotehost:8080/romannumeral?query=3999`
# Engineering And Testing Methodologies
  * Java 8
  * SpringBoot
  * SpringMVC
  * JUnit
  * SpringBoot Test
  * LogBack
# Package Layout
  * src
    * main
      * java
        * com
          * xing
            * config
            * constant
            * controller
              * exceptionahandlers
            * entity
            * service
              * impl
            * util
              * exception
      * resources
      * docker
    * test
      * java
        * com
          * xing
            * controller
            * service
