# Roman Number
A SpringBoot Application providing an endpoint that can convert an integer to a roman number.

# Build And Run
## Build With
  * Maven
  * Java 8
## How to Run
  1. clone the project `git clone https://github.com/XingxingLi2017/romannumber.git`
  2. run maven pacakge command `mvn pacakge`
  3. run springboot application with java command `java -jar .\target\romannumber-1.0-SNAPSHOT.jar`
  4. open the browser and access url `http://localhost:8080/romannumeral?query=3999`, if everything goes smoothly, you can see the JSON response like this 
  ![Response](https://github.com/XingxingLi2017/romannumber/blob/master/img/response.png)
  5. open the browser and access url `http://localhost:8080/romannumeral?query=-1`, you can get an error message like this
  ![Error](https://github.com/XingxingLi2017/romannumber/blob/master/img/outofrangeerror.png)
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
    * test
      * java
        * com
          * xing
            * controller
            * service
