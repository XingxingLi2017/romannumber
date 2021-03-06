# Roman Number
A SpringBoot Application providing an endpoint that can convert an integer to a roman number.
## Roman Number Specification
[Roman Number Specification Reference](https://en.wikipedia.org/wiki/Roman_numerals)
# Build And Run
## Build With
  * Maven
  * Java 8
## How to Run
  1. clone the project `git clone https://github.com/XingxingLi2017/romannumber.git`
  2. enter the project directory `cd romannumber`
  3. run maven package command `mvn pacakge`
  4. run springboot application with java command `java -jar .\target\romannumber.jar`
  5. open the browser and access url `http://localhost:8080/romannumeral?query=3999`, if everything goes smoothly, you can see the JSON response like this 
  ![Response](https://github.com/XingxingLi2017/romannumber/blob/master/img/response.png)
  6. open the browser and access url `http://localhost:8080/romannumeral?query=-1`, you can get an error message like this
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
  * Conduct unit testing with JUnit and SpringBoot test library. 
Mock up requests by using `MockMvc` object to send `get` requests to the endpoint. 
  * Convert integer by using predefined `romanNumberUnits` in `application.yaml` file. We predefined 4 arrays:
`M=["", "M", "MM", "MMM"]`, `C=["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]`,
`X=["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]` and `I=["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]`.
When we get a new integer `num`, we divided it by 1000, 100, 10 and get the corresponding Roman Units. 
Resulting String `ret = M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10]`.
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
# Dependencies
  * SpringBoot
  * SpringMVC
  * Jackson JSON Converter
  * JUnit
  * SpringBoot Test
  * Logback
  * Docker Maven Plugin
  * Spring Boot Maven Plugin
  * Tomcat Server